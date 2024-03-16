exports.getSchedule = (req, res, next) => {
    console.log(req.body.year);
    next();
}