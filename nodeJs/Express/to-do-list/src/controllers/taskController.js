const Task = require('../models/Task')


const createTask = async (req, res) => {
    try {
      const { title, detail } = req.body
      const newTask = await Task.create({ title, detail });
      res.status(201).json(newTask)
    } catch (error) {
      res.status(500).send('Error creating task');
    }
  }
const getAllTasks = async (req, res) => {
    try {
      const tasks = await Task.findAll();
      res.json(tasks);
    } catch (error) {
      res.status(500).send('Error fetching tasks');
    }
};

const gettaskById = async (req, res) => {
    try {
      const taskId = req.params.id
      const task = await Task.findByPk(taskId)
      if (!task) {
        return res.sendStatus(404)
      }
      res.json(task)
  
    } catch (error) {
      res.status(500).send('Error fetching task');
    }
  }

const updateTask = async (req, res) => {
    try {
        const taskId = req.params.id
        const data = req.body;
        const task = await Task.findByPk(taskId)
        if (!task) {
          return res.sendStatus(404)
        }
        await task.update(data);
        res.json(task);
      } catch (error) {
        console.log(error)
        res.status(500).send('Error updating task');
      }
    }

const deleteTask = async (req, res) => {
    try {
        const taskId = req.params.id
        const task = await Task.findByPk(taskId)
        if (!task){
          return res.sendStatus(404)
        }
        await task.destroy()
        res.sendStatus(204)
      } catch (error) {
    
      }
      
    }

  module.exports = {
    createTask,
    getAllTasks,
    gettaskById,
    updateTask,
    deleteTask
  };