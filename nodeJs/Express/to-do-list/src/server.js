const express = require('express')
const app = express()
const sequelize = require("./config/database");
const Tag = require("./models/Tag")
const Task = require("./models/Task")
const TaskTag = require("./models/TaskTag")

// Import Router
const tagRouter = require("./routes/tagRouter")
const taskRouter = require("./routes/taskRouter")


// Sync the models with the database
sequelize.sync({ force: false })
  .then(() => {
    console.log('Database and tables synced!');
  })
  .catch((err) => {
    console.error('Error syncing database:', err);
  });


  // Middleware for parsing JSON and URL-encoded bodies
app.use(express.json()); // Parse JSON bodies
app.use(express.urlencoded({ extended: true })); // Parse URL-encoded bodies

// Use the routers
app.use('/tags', tagRouter); 
app.use('/tasks', taskRouter);

app.listen(8000, () => {
    console.log('Start Server at port 8000')
})