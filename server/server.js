const express = require("express");
const app = express();
const PORT = 4444;
app.use(express.json());
app.get("/",(req,res) =>{
    res.send("hi from server")
    res.send(req.body.name);

});
app.post("/", (req,res) =>{
    console.log("Request body:",req.body);
    const name = req.body;
    res.send(`<h1>name</h1>`);
    // res.send("Recieved!");
})
// app.get("/n",(req,res)=>{
//     res.send(name)
// })
app.listen(PORT,() =>{
    console.log(`Server is running on http://localhost:${PORT}`);
})