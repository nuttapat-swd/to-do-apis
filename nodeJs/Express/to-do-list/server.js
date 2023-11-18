const express = require('express')
const app = express()

app.get('/', (req, res) => {
    res.send('TEst TESt Test')
})

app.listen(8000, () => {
    console.log('Start Server at port 8000')
})