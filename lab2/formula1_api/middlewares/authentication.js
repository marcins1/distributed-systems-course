exports.verifyApiKey = (req, res, next) => {
  const apiKeys = process.env.API_KEYS.split(",");
  if (!apiKeys.includes(req.body.api_key)) {
    res.status(401).send("Unauthorized");
    return;
  }
  next();
};
