const express = require('express')
const app = express()
const sequelize = require("./config/database");
const Tag = require("./models/Tag")
const Task = require("./models/Task")
const TaskTag = require("./models/TaskTag")


// Sync the models with the database
sequelize.sync({ force: true })
  .then(() => {
    console.log('Database and tables synced!');
  })
  .catch((err) => {
    console.error('Error syncing database:', err);
  });


app.get('/', (req, res) => {
    res.send('TEst TESt Test')
})

app.listen(8000, () => {
    console.log('Start Server at port 8000')
})