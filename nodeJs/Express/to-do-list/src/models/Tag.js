const { DataTypes, Model } = require('sequelize')
const db = require('./src/config/database')

const Tag = db.define('Tag', {
    id: {
        type: DataTypes.INTEGER,
        autoIncrement: true,
        primaryKey: true,
    },
    title: {
        type: DataTypes.STRING,
        allowNull: false
    },
    color: {
        type: DataTypes.STRING,
        allowNull: false,
        defaultValue: "#FFFFFF",
    }
})

module.exports = Tag