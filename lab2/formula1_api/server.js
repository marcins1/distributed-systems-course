const express = require("express");
const path = require("path");
const fetch = (...args) =>
  import("node-fetch").then(({ default: fetch }) => fetch(...args));
require("dotenv").config();
const app = express();

const authentication = require("./middlewares/authentication");
const validation = require("./middlewares/validation");

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static(__dirname + "/public"));

const fetchData = async (url, options = { method: "GET" }) => {
  const resultFromApi = await fetch(url, options);
  const json = resultFromApi.json();
  return json;
};

const htmlUp = `<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Get drivers</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
  </head>
  <body>
    <nav class="navbar">
      <div><p class="logo">F1 API</p></div>
      <ul class="navbar-links">
        <li class="active"><a href="/schedule">SCHEDULE</a></li>
        <li><a href="/drivers">DRIVERS</a></li>
        <li><a href="/informations">INFORMATIONS</a></li>
      </ul>
    </nav>
    <main class="main-container">
      <h1>Informations</h1>`;

const htmlDown = `</main>
                </body>
              </html>`;

app.get("/", function (req, res) {
  res.sendFile(path.join(__dirname, "/src/html/index.html"));
});

app.get("/schedule", function (req, res) {
  res.sendFile(path.join(__dirname, "/src/html/schedule.html"));
});

app.get("/drivers", function (req, res) {
  res.sendFile(path.join(__dirname, "/src/html/drivers.html"));
});

app.get("/informations", function (req, res) {
  res.sendFile(path.join(__dirname, "/src/html/informations.html"));
});

app.post("/getSchedule", authentication.verifyApiKey, validation.validateYearForm, async function (req, res) {
    const url = `http://ergast.com/api/f1/${req.body.year}.json`;
    let json;

    try {
      json = await fetchData(url);
    } catch (err) {
      res.status(500).send("Error fetching data from Ergast API");
      return;
    }

    if (json.MRData.RaceTable.Races.length === 0) {
      res.status(404).send(`Schedule for year ${req.body.year} not found.`);
      return;
    }

    let resultHtml = `<h1>Year: ${json.MRData.RaceTable.season}</h1>`;

    // console.log(json);
    // console.log(json.MRData.RaceTable.Races[0]);

    resultHtml += `<table>
                  <thead>
                    <tr>
                      <th>Round</th>
                      <th>Race name</th>
                      <th>Date</th>
                      <th>Time</th>
                      <th>Country</th>
                      <th>Locality</th>
                    </tr>
                  </thead>
                  <tbody>`;

    json.MRData.RaceTable.Races.forEach((race) => {
      resultHtml += `<tr>`;
      resultHtml += `<td>${race.round}</td>`;
      resultHtml += `<td>${race.raceName}</td>`;
      resultHtml += `<td>${race.date}</td>`;
      resultHtml += `<td>${race.time}</td>`;
      resultHtml += `<td>${race.Circuit.Location.country}</td>`;
      resultHtml += `<td>${race.Circuit.Location.locality}</td>`;
      // resultHtml += `<h2>${race.round}, ${race.raceName}, ${race.date}, ${race.time}, ${race.Circuit.Location.country}, ${race.Circuit.Location.locality}</h2>`;
    });

    resultHtml += `</tbody>
                </table>`;

    res.setHeader("Content-Type", "text/html");
    res.send(Buffer.from(htmlUp + resultHtml + htmlDown, "utf-8"));
  }
);

app.post("/getDrivers", authentication.verifyApiKey, validation.validateYearForm, async function (req, res) {
    const url = `http://ergast.com/api/f1/${req.body.year}/drivers.json`;
    let json;

    try {
      json = await fetchData(url);
    } catch (err) {
      res.status(500).send("Error fetching data from Ergast API");
      return;
    }
    // console.log(json.MRData.DriverTable);
    if (json.MRData.DriverTable.Drivers.length === 0) {
      res.status(404).send(`Driver list for year ${req.body.year} not found.`);
      return;
    }

    let resultHtml = `<h1>Year: ${json.MRData.DriverTable.season}</h1>`;

    json.MRData.DriverTable.Drivers.forEach((driver) => {
      resultHtml += `<h2>${driver.driverId}, ${driver.permanentNumber}, ${driver.code}, ${driver.url}, ${driver.givenName}, ${driver.familyName}, ${driver.dateOfBirth}, ${driver.nationality}</h2>`;
    });

    res.setHeader("Content-Type", "text/html");
    res.send(Buffer.from(htmlUp + resultHtml + htmlDown, "utf-8"));
  }
);

app.post("/getInformations", authentication.verifyApiKey, validation.validateGetInformationsForm, async function (req, res) {
    let sessions, driver, circuits, race_laps;
    const circuit_url = `https://ergast.com/api/f1/${req.body.year}/${req.body.round}/circuits.json`;
    const driver_url = `https://api.openf1.org/v1/drivers?last_name=${req.body.driver_surname}&first_name=${req.body.driver_name}&name_acronym=${req.body.name_acronym}&session_key=latest`;
    // console.log(circuit_url);
    // console.log(driver_url);

    try {
      [circuits, driver] = await Promise.all([
        fetchData(circuit_url),
        fetchData(driver_url),
      ]);
    } catch (err) {
      res.status(500).send("Error fetching data from Ergast API");
      return;
    }

    // console.log(circuits);
    // console.log("CIRCUIT");
    // console.log(circuits.MRData.CircuitTable.Circuits[0].Location.country);

    if (circuits.MRData.CircuitTable.Circuits.length === 0) {
      res
        .status(404)
        .send(
          `Circuit for year ${req.body.year} and round ${req.body.round} not found.`
        );
      return;
    }
    if (driver.length === 0) {
      res
        .status(404)
        .send(
          `Driver ${req.body.driver_name} ${req.body.driver_surname} ${req.body.name_acronym} not found.`
        );
      return;
    }

    const sessions_url = `https://api.openf1.org/v1/sessions?country_name=${circuits.MRData.CircuitTable.Circuits[0].Location.country}&year=${req.body.year}&location=${circuits.MRData.CircuitTable.Circuits[0].Location.locality}`;
    // console.log(sessions_url);

    try {
      sessions = await fetchData(sessions_url);
    } catch (err) {
      res.status(500).send("Error fetching data from OpenF1 API");
      return;
    }

    if (sessions.length === 0) {
      res
        .status(404)
        .send(
          `Session for year ${req.body.year} and location ${circuits.MRData.CircuitTable.Circuits[0].Location.locality} not found.`
        );
      return;
    }

    // console.log("PRINTING JSON")
    // console.log(driver);
    // console.log(sessions);

    let resultHtml = `<h1>Year: ${req.body.year}</h1>`;
    // Printing driver information
    Object.entries(driver[0]).forEach(([key, value]) => {
      resultHtml += `<h2>${key}: ${value}</h2>`;
    });

    // const qualifying = sessions.filter((session) => session.session_name == "Qualifying");
    // const sprint_shootout = sessions.filter((session) => session.session_name == "Sprint Shootout");
    // const sprint = sessions.filter((session) => session.session_name == "Sprint");
    const race = sessions.filter((session) => session.session_name == "Race");

    const race_laps_url = `https://api.openf1.org/v1/laps?session_key=${race[0].session_key}&driver_number=${driver[0].driver_number}`;

    try {
      race_laps = await fetchData(race_laps_url);
    } catch (err) {
      res.status(500).send("Error fetching data from OpenF1 API");
      return;
    }

    if (race_laps.length === 0) {
      res.status(404).send(`Laps for session not found.`);
    }

    // Printing circuits information
    resultHtml += `<h1>Session Information</h1>`;
    resultHtml += `<h2>${JSON.stringify(
      circuits.MRData.CircuitTable.Circuits
    )}</h2>`;

    // console.log(qualifying);
    // console.log(sprint_shootout);
    // console.log(sprint);
    // console.log(race);

    //Printing race laps information
    // console.log(race_laps);
    res.setHeader("Content-Type", "text/html");
    res.send(Buffer.from(htmlUp + resultHtml + htmlDown, "utf-8"));
  }
);

app.listen(3000);
