const fetch = (...args) =>
  import("node-fetch").then(({ default: fetch }) => fetch(...args));

const fetchData = async (url, options = { method: "GET" }) => {
  const resultFromApi = await fetch(url, options);
  const json = resultFromApi.json();
  return json;
};

exports.scheduleData = async (req) => {
  const url = `http://ergast.com/api/f1/${req.query.year}.json`;
  return await fetchData(url);
};

exports.driversData = async (req) => {
  const url = `http://ergast.com/api/f1/${req.query.year}/drivers.json`;
  return await fetchData(url);
};

exports.circuitAndDriverData = async (req) => {
  const circuit_url = `https://ergast.com/api/f1/${req.query.year}/${req.query.round}/circuits.json`;
  const driver_url = `https://api.openf1.org/v1/drivers?last_name=${req.query.driver_surname}&first_name=${req.query.driver_name}&name_acronym=${req.query.name_acronym}&session_key=latest`;
  return await Promise.all([fetchData(circuit_url), fetchData(driver_url)]);
};

exports.sessionsData = async (req, location) => {
  const sessions_url = `https://api.openf1.org/v1/sessions?country_name=${location.country}&year=${req.query.year}&location=${location.locality}`;
  return (sessions = await fetchData(sessions_url));
};

exports.getLapsData = async (sessions, driver) => {
  let qualifying_laps, race_laps, sprint_shootout_laps, sprint_laps;
  const qualifying = sessions.filter((session) => session.session_name == "Qualifying");
  const sprint_shootout = sessions.filter((session) => session.session_name == "Sprint Shootout");
  const sprint = sessions.filter((session) => session.session_name == "Sprint");
  const race = sessions.filter((session) => session.session_name == "Race");

  const qualifying_laps_url = `https://api.openf1.org/v1/laps?session_key=${qualifying[0].session_key}&driver_number=${driver.driver_number}`;
  const race_laps_url = `https://api.openf1.org/v1/laps?session_key=${race[0].session_key}&driver_number=${driver.driver_number}`;

  if (sprint.length === 0) {
    [qualifying_laps, race_laps] = await Promise.all([
      fetchData(qualifying_laps_url),
      fetchData(race_laps_url),
    ]);
    sprint_shootout_laps = [];
    sprint_laps = [];
  } else {
    const sprint_shootout_laps_url = `https://api.openf1.org/v1/laps?session_key=${sprint_shootout[0].session_key}&driver_number=${driver[0].driver_number}`;
    const sprint_laps_url = `https://api.openf1.org/v1/laps?session_key=${sprint[0].session_key}&driver_number=${driver[0].driver_number}`;
    [qualifying_laps, race_laps, sprint_shootout_laps, sprint_laps] =
      await Promise.all([
        fetchData(qualifying_laps_url),
        fetchData(race_laps_url),
        fetchData(sprint_shootout_laps_url),
        fetchData(sprint_laps_url),
      ]);
  }
  return [qualifying_laps, race_laps, sprint_shootout_laps, sprint_laps];
};
