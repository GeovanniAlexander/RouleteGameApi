# Roulete Game Demo
> Just a roulette game
## Endpoints:
### Create a roulette:
>host:8080/roulette/create   
>Return a message with the roulette id  
### Activate a roulette:
>host:8080/roulette/activate/{id}   
>The roulette id is a path variable and return a message with the roulette id
### View a roulettes:
>host:8080/roulette/   
>Return a list with the existing roulettes as the follow example
```json
[
    {
        "id": 1,
        "status": "cerrada"
    }
]
```
