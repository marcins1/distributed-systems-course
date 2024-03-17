const htmlLapTable = (data) => {
  let html =
  `<table>
    <thead>
      <tr>
        <th>Lap number</th>
        <th>Sector 1 time</th>
        <th>Sector 2 time</th>
        <th>Sector 3 time</th>
        <th>Pit lap</th>
        <th>Lap duration</th>
      </tr>
    </thead>
    <tbody>`;

  data.forEach((lap) => {
    html += `<tr>`;
    html += `<td>${lap.lap_number}</td>`;
    if (lap.duration_sector_1) {
      html += `<td>${lap.duration_sector_1}</td>`;
    } else {
      html += `<td>-</td>`;
    }
    if (lap.duration_sector_2) {
      html += `<td>${lap.duration_sector_2}</td>`;
    } else {
      html += `<td>-</td>`;
    }
    if (lap.duration_sector_3) {
      html += `<td>${lap.duration_sector_3}</td>`;
    } else {
      html += `<td>-</td>`;
    }
    if (lap.is_pit_out_lap) {
      html += `<td>Yes</td>`;
    } else {
      html += `<td>No</td>`;
    }
    if (lap.lap_duration) {
      html += `<td>${lap.lap_duration}</td>`;
    } else {
      html += `<td>-</td>`;
    }
  });

  html += `</tbody></table>`;
  return html;
};

exports.htmlRacesTable = (races) => {
  let html = 
  `<table>
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

  races.forEach((race) => {
    html += `<tr><td>${race.round}</td>`;
    html += `<td>${race.raceName}</td>`;
    html += `<td>${race.date}</td>`;
    html += `<td>${race.time}</td>`;
    html += `<td>${race.Circuit.Location.country}</td>`;
    html += `<td>${race.Circuit.Location.locality}</td></tr>`;
  });

  html += `</tbody></table>`;
  return html;
};

exports.htmlDriversTable = (drivers) => {
  let html =
  `<table>
    <thead>
      <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Name acronym</th>
        <th>Number</th>
        <th>Nationality</th>
        <th>Date of birth</th>
      </tr>
    </thead>
    <tbody>`;

  drivers.forEach((driver) => {
    html += `<tr><td>${driver.givenName}</td>`;
    html += `<td>${driver.familyName}</td>`;
    html += `<td>${driver.code}</td>`;
    html += `<td>${driver.permanentNumber}</td>`;
    html += `<td>${driver.nationality}</td>`;
    html += `<td>${driver.dateOfBirth}</td></tr>`;
  });

  html += `</tbody></table>`;
  return html;
};

exports.buildHtml = (content) => {
  const htmlUp = 
  `<!DOCTYPE html>
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
          <li><a href="/schedule">SCHEDULE</a></li>
          <li><a href="/drivers">DRIVERS</a></li>
          <li><a href="/informations">INFORMATIONS</a></li>
        </ul>
      </nav>
      <main class="main-container">`;

  const htmlDown = `</main></body></html>`;

  return htmlUp + content + htmlDown;
};

exports.htmlDriverInformations = (driver) => {
  let html = `<h1>Informations about driver</h1>`;
  html += `<img src="${driver.headshot_url}" alt="Driver image"></img>`;
  html += `<p>First name: ${driver.first_name}</p>`;
  html += `<p>Last name: ${driver.last_name}</p>`;
  html += `<p>Name acronym: ${driver.name_acronym}</p>`;
  html += `<p>Driver number: ${driver.driver_number}</p>`;
  html += `<p>Driver team: ${driver.team_name}</p>`;
  return html;
}

exports.htmlCircuitInformations = (circuit) => {
  let html = `<h1>Circuit informations</h1>`;
  html += `<p>Circuit name: ${circuit.circuitName}</p>`;
  html += `<p>Country: ${circuit.Location.country}</p>`;
  html += `<p>Locality: ${circuit.Location.country}</p>`;
  return html;
}

exports.htmlSessionsInformations = (qualifying, sprint_shootout, sprint, race) => {
  html = ``;
  if (qualifying.length !== 0) {
    html += `<h1>Qualifying statistics</h1>`;
    html += htmlLapTable(qualifying);
  }
  if (sprint_shootout.length !== 0) {
    html += `<h1>Sprint shootout statistics</h1>`;
    html += htmlLapTable(sprint_shootout);
  }
  if (sprint.length !== 0) {
    html += `<h1>Sprint statistics</h1>`;
    html += htmlLapTable(sprint);
  }
  if (race.length !== 0) {
    html += `<h1>Race statistics</h1>`;
    html += htmlLapTable(race);
  }
  return html;
}