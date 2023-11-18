const { DataTypes } = require('sequelize')
const db = require('./src/config/database')

const Task = db.define('Task', {
    id: {
        type: DataTypes.INTEGER,
        autoIncrement: true,
        primaryKey: true,
    },
    title: {
        type: DataTypes.STRING,
        allowNull: false
    },
    detail: {
        type: DataTypes.TEXT,
        allowNull: true
    },
    is_checked : {
        type: DataTypes.BOOLEAN,
        defaultValue: false
    }
})

module.exports = Task;