const express = require('express')
const app = express()
const sequelize = require("D:/SWD/project/to-do-apis/nodeJs/Express/to-do-list/src/config/database");
const Tag = require("../src/models/Tag")
const Task = require("../src/models/Task")
const TaskTag = require("../src/models/TaskTag")


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