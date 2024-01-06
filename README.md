# To-Do-List

My repository for learning Backend Programming Language and Framework to work at same features.

### Targets

**Pytohn** : `✅ Django REST Framework` `FastAPI` `Flask`
**Node.JS** : `✅ ExpressJS` `NestJS`
**Java** : `✅ Spring Boot`
**Go (Golang)** : `👨🏻‍💻 Gin` `Echo` `Fiber` `Gorilla Mux`
**Ruby** : `Ruby On Rails`
**PHP** : `Laravel` `Lumen`
**Rust** : `Rocket` `Axum`
**.Net** : `ASP.NET`


## Features

In this project will can **CRUD** `Tasks` and `Tags`.


![dbdiagram](https://i.ibb.co/b7FGtGF/c3f0fd4f-e3d0-4a46-bf2b-3ebdcf9e078d.jpg)

The `Task` will have `add-tag` and `check` API actions.
And data will be stored in the database (PostgreSQL).


## APIs Documentation

### Tags

- ***Create a new tag***
```http
POST /tags/
```
body:
```json
{
    "title": "test",
    "color": "#000000",
}
```

- ***Get all tags***
```http
GET /tags/
```

- ***Get tag by ID***
```http
GET /tags/<id>
```

- ***Update tag***
```http
PATCH /tags/<id>
```
body:
```json
{
    "title": "test",
    "color": "#000000",
}
```

- ***Delete tag***
```http
DELETE /tags/<id>
```

### Tasks

- ***Create a new tag***
```http
POST /tasks/
```
body:
```json
{
    "title": "test",
    "color": "#000000",
}
```

- ***Get all tasks***
```http
GET /tasks/
```

- ***Get tag by ID***
```http
GET /tasks/<id>
```

- ***Update tag***
```http
PATCH /tasks/<id>
```
body:
```json
{
    "title": "test",
    "color": "#000000",
}
```

- ***Delete tag***
```http
DELETE /tasks/<id>
```

- ***Add tag(s) to task*****
```http
POST /tasks/<id>
```
body:
```json
{
    "tags": [1, 2] // tag ids
}
```

- ***Change task status*****
```http
PATCH /tasks/<id>/check
```
body:
```json
{
    "is_checked": true
}
```