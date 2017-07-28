//--------------------------------------------------------------------------------
// Useful sample data
//--------------------------------------------------------------------------------

//POST
var roles = [
    {
        "name": "role1",
        "useYn": "Y"
    },
    {
        "name": "role2",
        "useYn": "Y"
    },
    {
        "name": "role3",
        "useYn": "Y"
    },
    {
        "name": "role4",
        "useYn": "Y"
    },
    {
        "name": "role5",
        "useYn": "Y"
    },
    {
        "name": "role6",
        "useYn": "Y"
    }
]

//POST
var permissions = [
    {
        "name": "state.product.search"
    },
    {
        "name": "state.product.detail"
    },
    {
        "name": "state.product.register"
    },
    {
        "name": "state.product.orderSearch"
    },
    {
        "name": "state.product.orderRegister"
    },
    {
        "name": "state.product.orderDetail"
    },


    {
        "name": "state.order.search"
    },
    {
        "name": "state.order.returnSearch"
    },
    {
        "name": "state.order.rejectSearch"
    },

    {
        "name": "state.member.search"
    }
]

var permissions2 = [
    {
        "name": "action.search.product"
    },
    {
        "name": "action.search.plorder"
    },
    {
        "name": "action.search.member"
    },
    {
        "name": "action.search.order"
    },
    {
        "name": "action.search.orderReturn"
    },
    {
        "name": "action.search.orderReject"
    },


    {
        "name": "action.approve.product"
    },
    {
        "name": "action.approve.plorder"
    },

    {
        "name": "action.register.product"
    },
    {
        "name": "action.register.plorder"
    },

    {
        "name": "action.update.product"
    },
    {
        "name": "action.update.plorder"
    }
]


// PUT
var role_permission = [
    {
        "id": 1,
        "name": "role1",
        "permissions": [
            {
                "id": 1
            },
            {
                "id": 2
            },
            {
                "id": 3
            },
            {
                "id": 4
            },
            {
                "id": 5
            },
            {
                "id": 6
            },
            {
                "id": 7
            },
            {
                "id": 8
            },
            {
                "id": 9
            },
            {
                "id": 10
            },
            {
                "id": 11
            }
        ]
    },
    {
        "id": 2,
        "name": "role2",
        "permissions": [
            {
                "id": 1,
                "name": "state.product.search"
            },
            {
                "id": 2,
                "name": "state.product.detail"
            },
            {
                "id": 3,
                "name": "state.product.register"
            },
            {
                "id": 4,
                "name": "state.product.orderSearch"
            },
            {
                "id": 5,
                "name": "state.product.orderRegister"
            },
            {
                "id": 6,
                "name": "state.product.orderDetail"
            }
        ]
    },
    {
        "id": 3,
        "name": "role3",
        "permissions": [
            {
                "id": 1,
                "name": "state.product.search"
            },
            {
                "id": 3,
                "name": "state.product.register"
            },
            {
                "id": 7
            },
            {
                "id": 8
            }
        ]
    },
    {
        "id": 4,
        "name": "role4",
        "permissions": [
            {
                "id": 1
            }
        ]
    },
    {
        "id": 5,
        "name": "role5",
        "permissions": [
            {
                "id": 7
            },
            {
                "id": 8
            },
            {
                "id": 9
            }
        ]
    },
    {
        "id": 6,
        "name": "role6",
        "permissions": [
            {
                "id": 10
            }
        ]
    }
]


//TODO: path or state ???
// POST
var user_role = [
    {
        "username": "a",
        "password": "a",
        "firstName": "a",
        "lastName": "BO",
        "role": {
            "id": 1,
            "name": "role1",
            "permissions": [
                {
                    "id": 1,
                    "name": "state.product.search"
                },
                {
                    "id": 2,
                    "name": "state.product.register"
                },
                {
                    "id": 3,
                    "name": "state.product.orderSearch"
                },
                {
                    "id": 11
                }
            ]
        }
    },
    {
        "username": "user2",
        "password": "user2",
        "firstName": "user2",
        "lastName": "BO",
        "role": {
            "id": 2
        }
    },
    {
        "username": "user3",
        "password": "user3",
        "firstName": "user3",
        "lastName": "BO",
        "role": {
            "id": 3,
            "name": "role3"
        }
    },
    {
        "username": "user4",
        "password": "user4",
        "firstName": "user4",
        "lastName": "BO",
        "role": {
            "id": 4
        }
    },
    {
        "username": "user5",
        "password": "user5",
        "firstName": "user5",
        "lastName": "BO",
        "role": {
            "id": 5
        }
    },
    {
        "username": "user6",
        "password": "user6",
        "firstName": "user6",
        "lastName": "BO",
        "role": {
            "id": 6
        }
    }
]

//
