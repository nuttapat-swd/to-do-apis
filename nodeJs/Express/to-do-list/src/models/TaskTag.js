const { DataTypes, Model } = require('sequelize')
const db = require('./src/config/database')
const Task = require('./src/models/Task')
const Tag = require('./src/models/Task')

const TaskTag = db.define('UserRole', {
    id: {
        type: DataTypes.INTEGER,
        autoIncrement: true,
        primaryKey: true,
    },
  });

// Establishing the many-to-many relationship
Task.belongsToMany(Tag, { through: TaskTag });
Tag.belongsToMany(Task, { through: TaskTag });

module.exports = TaskTag;
