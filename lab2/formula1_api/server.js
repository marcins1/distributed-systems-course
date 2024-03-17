const express = require("express");
const path = require("path");
require("dotenv").config();
const app = express();

const authentication = require("./middlewares/authentication");
const validation = require("./middlewares/validation");
const generators = require("./helpers/htmlGenerators");
const data = require("./helpers/data");

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(express.static(__dirname + "/public"));

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

app.get("/getSchedule", authentication.verifyApiKey, validation.validateYearForm, async function (req, res) {
    let schedule;
    try {
      schedule = await data.scheduleData(req);
    } catch (err) {
      res.status(500).send("Error fetching data from Ergast API");
      return;
    }
    if (schedule.MRData.RaceTable.Races.length === 0) {
      res.status(404).send(`Schedule for year ${req.query.year} not found.`);
      return;
    }
    let content = `<h1>Schedule for ${schedule.MRData.RaceTable.season} season</h1>`;
    content += generators.htmlRacesTable(schedule.MRData.RaceTable.Races);
    res.setHeader("Content-Type", "text/html");
    res.send(Buffer.from(generators.buildHtml(content), "utf-8"));
  }
);

app.get("/getDrivers", authentication.verifyApiKey, validation.validateYearForm, async function (req, res) {
    let drivers;
    try {
      drivers = await data.driversData(req);
    } catch (err) {
      res.status(500).send("Error fetching data from Ergast API");
      return;
    }
    if (drivers.MRData.DriverTable.Drivers.length === 0) {
      res.status(404).send(`Driver list for year ${req.query.year} not found.`);
      return;
    }
    let content = `<h1>Drivers in ${drivers.MRData.DriverTable.season} season</h1>`;
    content += generators.htmlDriversTable(drivers.MRData.DriverTable.Drivers);
    res.setHeader("Content-Type", "text/html");
    res.send(Buffer.from(generators.buildHtml(content), "utf-8"));
  }
);

app.get("/getInformations", authentication.verifyApiKey, validation.validateGetInformationsForm, async function (req, res) {
    let sessions, driver, circuits, race_laps, qualifying_laps, sprint_shootout_laps, sprint_laps;
    sprint_shootout_laps = [];
    sprint_laps = [];

    try {
      [circuits, driver] = await data.circuitAndDriverData(req);
    } catch (err) {
      res.status(500).send("Error fetching data from Ergast API");
      return;
    }
    if (circuits.MRData.CircuitTable.Circuits.length === 0) {
      res.status(404).send(`Circuit for year ${req.query.year} and round ${req.query.round} not found.`);
      return;
    }
    if (driver.length === 0) {
      res.status(404).send(`Driver ${req.query.driver_name} ${req.query.driver_surname} ${req.query.name_acronym} not found.`);
      return;
    }

    try {
      sessions = await data.sessionsData(req, circuits.MRData.CircuitTable.Circuits[0].Location);
    } catch (err) {
      res.status(500).send("Error fetching data from OpenF1 API");
      return;
    }
    if (sessions.length === 0) {
      res.status(404).send(`Session for year ${req.query.year} and location ${circuits.MRData.CircuitTable.Circuits[0].Location.locality} not found.`);
      return;
    }
    
    let content = generators.htmlDriverInformations(driver[0]);

    try {
      [qualifying_laps, race_laps, sprint_shootout_laps, sprint_laps] = await data.getLapsData(sessions, driver[0]);
    } catch (err) {
      res.status(500).send("Error fetching data from OpenF1 API");
      return;
    }
    if (qualifying_laps.length === 0 && race_laps.length === 0 && sprint_shootout_laps.length === 0 && sprint_laps.length === 0) {
      res.status(404).send(`Laps for sessions not found.`);
      return;
    }

    content += generators.htmlCircuitInformations(circuits.MRData.CircuitTable.Circuits[0]);
    content += generators.htmlSessionsInformations(qualifying_laps, sprint_shootout_laps, sprint_laps, race_laps);
    res.setHeader("Content-Type", "text/html");
    res.send(Buffer.from(generators.buildHtml(content), "utf-8"));
  }
);

app.listen(3000);
