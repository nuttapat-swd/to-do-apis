const { DataTypes, Model } = require('sequelize')
const db = require('../config/database')
const Task = require('./Task')
const Tag = require('./Tag')

const TaskTag = db.define('TaskTag', {
    id: {
        type: DataTypes.INTEGER,
        autoIncrement: true,
        primaryKey: true,
    },
  });

// Establishing the many-to-many relationship
Task.belongsToMany(Tag, { as: 'TagList', through: TaskTag, foreignKey: 'taskId'});
Tag.belongsToMany(Task, { as: 'Taskserd', through: TaskTag, foreignKey: 'tagId' });

module.exports = TaskTag;
