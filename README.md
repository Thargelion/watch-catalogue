# Watch Catalogue

![technology Java-14](https://img.shields.io/badge/technology-java_14-green.svg)
![version](https://img.shields.io/github/v/tag/Thargelion/watch-catalogue?style=plastic)

## Preamble

This API calculates the final price of list of products. Each product may have a special discount based in the amount of
items bought.

## Installation

We use Maven as software management Tool:

```shell
mvn clean install
```

## Running

Use native mvn:

```shell
mvn spring-boot run
```

Or the provided executable:

```shell

./mvnw spring-boot:run

```

## Using

```shell
curl --location --request POST 'localhost:8080/checkout' \
--header 'Content-Type: application/json' \
--data-raw '[
    "001",
    "002",
    "003"
]'
```

| Request                        | Response           |
| :----                          | :-----             |
|  POST: localhost:8080/checkout | {"price": number } |

## Design

Spite built as Time To Market, this API was designed to be capable of scaling with new features or technologies:

### Domain Driven

The aspects of the business domain are handled inside a proper package.

### API Package

The interface that communicates with the users is separated from the domain.

### Repository

The logic to access resources is in its own package. As the domain services consumes generic Repositories, future new
storage databases can be added without much effort.

## Solving procedure

First a harcoded endpoint was built. This allowed to have an API capable of returning a body with the expected model as
fast as possible. This is useful to other teams or clients that may need to see or interact with our API before having
the actual logic developed.

Then we separated our domain in four entities: Watch, a Discount, An Inventory and Total Price:

### Watch

This is the representation of the product to sell. Currently it contains data and is stored inside files in resources
folder.

### Inventory

This is the generic representation of the ecommerce items. It has a SellableItem with just an Identification and a
Price, a Sellable Repository where to store and read Sellable Items, an Amount Object that stores an amount of items in
a specific moment and a CountedRequest that coverts an Array of Ids into an Array of Amounts providing the logic
required to recognize the amount of items recieved from the user.

### Discount

This handles the logic required to apply a discount to a SellableItem and how to store It (using DiscountRepository)

### Total Price

This calculates the final price using the received IDs, looking after proper repositories and then calculating using
Amount.

1. Receive List of IDS
2. Build the list of amounts of each id
3. Look if the item has a discount
4. In case of discount, apply it and move into next id
5. If no discount was found, applies the regular price
6. Returns TotalPrice with the sum of all prices.

## Next Steps

Migrate from files to a proper database.

Add CRUD operations to be able to edit items and discounts.

Add CI/CD.

Add proper Metrics and statistics such as P50, P95, and P99.

Elevate coverage.

A different way of dealing with optional discounts is to have default values of minimum amount of 1 and a price equal to the 'regular' price. This reduces the amount of modles required but requires to always calculate a discount.
