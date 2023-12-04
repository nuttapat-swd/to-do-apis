const express = require('express');
const router = express.Router();
const taskController = require('../controllers/taskController')

// Routes mapping to controller functions
router.get('/', taskController.getAllTasks)
router.get('/:id', taskController.gettaskById)
router.post('/', taskController.createTask)
router.patch('/:id', taskController.updateTask)
router.delete('/:id', taskController.deleteTask)

module.exports = router ;