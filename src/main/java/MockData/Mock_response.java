package MockData;

public class Mock_response {
    public static String complexJson(){
        String jsonResponse;
        jsonResponse = """
        {
          "status": "success",
          "data": {
            "users": [
              {
                "id": 1,
                "name": {
                  "first": "John",
                  "last": "Doe"
                },
                "age": 30,
                "email": "john.doe@example.com",
                "roles": ["admin", "editor"],
                "address": {
                  "street": "123 Main St",
                  "city": "Springfield",
                  "state": "Illinois",
                  "country": "Bangladesh",
                  "zipcode": "62701"
                },
                "active": true,
                "orders": [
                  {
                    "orderId": "A001",
                    "amount": 250.75,
                    "items": [
                      {"itemId": "P001", "name": "Laptop", "quantity": 1},
                      {"itemId": "P002", "name": "Mouse", "quantity": 2},
                      {"itemId": "P003", "name": "Monitor", "quantity": 1},
                      {"itemId": "P004", "name": "Speaker", "quantity": 2},
                      {"itemId": "P005", "name": "Cables", "quantity": 5}
                    ]
                  },
                  {
                    "orderId": "A002",
                    "amount": 99.99,
                    "items": [
                      {"itemId": "P003", "name": "Keyboard", "quantity": 1}
                    ]
                  }
                ]
              },
              {
                "id": 2,
                "name": {
                  "first": "Jane",
                  "last": "Smith"
                },
                "age": 25,
                "email": "jane.smith@example.com",
                "roles": ["user"],
                "address": {
                  "street": "456 Elm St",
                  "city": "Seattle",
                  "state": "Washington",
                  "country": "United States",
                  "zipcode": "98101"
                },
                "active": false,
                "orders": []
              }
            ],
            "meta": {
              "totalUsers": 2,
              "requestId": "abcd-1234-efgh-5678",
              "timestamp": "2024-12-27T12:34:56Z"
            }
          },
          "message": "User data fetched successfully"
        }
        """;

        return jsonResponse;
    }
}
