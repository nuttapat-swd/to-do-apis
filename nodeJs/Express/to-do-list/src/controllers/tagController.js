const Tag = require('../models/Tag')

let tagMoc = [
  { id: 1, title: 'Alice' },
  { id: 2, title: 'Bob' },
];

// GET: Get all tags
const getAllTags = async (req, res) => {
  try {
    const tags = await Tag.findAll();
    res.json(tags);
  } catch (error) {
    res.status(500).send('Error fetching tags');
  }
};

const getTagById = async (req, res) => {
  try {
    const tagId = req.params.id
    const tag = await Tag.findByPk(tagId)
    if (!tag) {
      return res.sendStatus(404)
    }
    res.json(tag)

  } catch (error) {
    res.status(500).send('Error fetching tag');
  }
}

const createTag = async (req, res) => {
  try {
    const { title, color } = req.body
    const newTag = await Tag.create({ title, color });
    res.status(201).json(newTag)
  } catch (error) {
    res.status(500).send('Error creating tag');
  }
}

const updateTag = async (req, res) => {
  try {
    const tagId = req.params.id;
    const data = req.body;
    const tag = await Tag.findByPk(tagId);
    if (!tag) {
      return res.sendStatus(404)
    }
    await tag.update(data);
    res.json(tag);
  } catch (error) {
    console.log(error)
    res.status(500).send('Error updating tag');
  }
}

const deleteTag = async (req, res) => {
  try {
    const tagId = req.params.id;
    const tag = await Tag.findByPk(tagId);
    if (!tag){
      return res.sendStatus(404)
    }
    await tag.destroy()
    res.sendStatus(204)
  } catch (error) {

  }
  
}

module.exports = {
  getAllTags,
  getTagById,
  createTag,
  updateTag,
  deleteTag
};