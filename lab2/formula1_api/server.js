const express = require('express');
const path = require('path');
const app = express();

const ergastApi = require("./middlewares/ergastApi");
  
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

app.get('/', function (req, res) {
  res.sendFile(path.join(__dirname, '/src/html/index.html'));
})

app.get('/schedule', function (req, res) {
  res.sendFile(path.join(__dirname, '/src/html/schedule.html'));
})

app.post('/getSchedule', ergastApi.getSchedule, function (req, res) {
  res.sendFile(path.join(__dirname, '/src/html/index.html'));
})

app.listen(3000);