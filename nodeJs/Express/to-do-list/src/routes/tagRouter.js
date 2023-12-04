const express = require('express');
const router = express.Router();
const tagController = require('../controllers/tagController')

// Routes mapping to controller functions
router.get('/', tagController.getAllTags)
router.get('/:id', tagController.getTagById)
router.post('/', tagController.createTag)
router.patch('/:id', tagController.updateTag)
router.delete('/:id', tagController.deleteTag)



// router.get('/', (req, res) => {
//     res.send('Get all users');
//   });

module.exports = router ;