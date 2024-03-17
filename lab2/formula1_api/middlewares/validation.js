exports.validateYearForm = (req, res, next) => {
  if (!req.body.year) {
    res.status(400).send("Year is required");
    return;
  } else if (!/^[12]\d{3}$/.test(req.body.year)) {
    res.status(400).send("Year must be a 4 digit number");
    return;
  }
  next();
};

exports.validateGetInformationsForm = (req, res, next) => {
  if (!req.body.year) {
    res.status(400).send("Year is required");
    return;
  } else if (!req.body.round) {
    res.status(400).send("Round is required");
    return;
  } else if (!req.body.driver_name) {
    res.status(400).send("Driver name is required");
    return;
  } else if (!req.body.driver_surname) {
    res.status(400).send("Driver surname is required");
    return;
  } else if (!req.body.name_acronym) {
    res.status(400).send("Driver name acronym is required");
    return;
  } else if (!/^[12]\d{3}$/.test(req.body.year)) {
    res.status(400).send("Year must be a 4 digit number");
    return;
  } else if (!/^\d{1,2}$/.test(req.body.round)) {
    res.status(400).send("Round must be a 2 digit number");
    return;
  } else if (!/^[^\s]+(?: [^\s]+)*$/u.test(req.body.driver_name)) {
    res.status(400).send("Driver name must contain only letters and spaces");
    return;
  } else if (!/^[^\s]+(?: [^\s]+)*$/u.test(req.body.driver_surname)) {
    res.status(400).send("Driver surname must contain only letters and spaces");
    return;
  } else if (!/^\p{Lu}{3}$/u.test(req.body.name_acronym)) {
    res
      .status(400)
      .send("Driver name acronym must contain only three capital letters");
    return;
  }
  next();
};
