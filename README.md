# Roulete Game Demo
> Just a roulette game
## Endpoints:
### Create a roulette:
>host:8080/roulette/create   
>Return a message with the roulette id  
### Activate a roulette:
>host:8080/roulette/activate/{id}   
>The roulette id is a path variable and return a message as confirmation
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
### Make a bet:
>host:8080/bet/create  
>The bet parameters are sent as a json in the body of the petition as the follow example and return a message with confirmation or negation  
```json
{
    "amount":"10000",
    "num": 30,     
    "color":"rojo",  
    "roulette": 
    {
        "id": 1
    }
}
```
> "num" and "color" are optional  
> "num" must be between 0 and 36  
> "color" must be 'rojo' or 'negro'  
> "amount" must be between 1 and 10000
