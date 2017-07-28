//--------------------------------------------------------------------------------
// 기본 데이터 설정
//--------------------------------------------------------------------------------
// POST
// role1 : admin, role2 : part, role3 : guest (just menu observer)
var roles = [
    {
        "name": "role0"
    },
    {
        "name": "role1"
    },
    {
        "name": "role2"
    },
    {
        "name": "role3"
    },
    {
        "name": "role4"
    },
    {
        "name": "role5"
    }
]

var step1_1 = [
    {
        "name": "permission1"
    },
    {
        "name": "permission2"
    },
    {
        "name": "permission3"
    }
]

var step2_1= {
    "id": 1,
    "name": "role1",
    "permissions": [
        {
            "id": 1,
            "name": "permission1"
        },
        {
            "id": 2,
            "name": "permission2"
        },
        {
            "id": 3,
            "name": "permission3"
        }
    ]
}

// permission 정보는 id 만 주어도 설정 가능하다.
var step2_1= {
    "id": 2,
    "name": "role2",
    "permissions": [
        {
            "id": 2
        }
    ]
}

var step2_1= {
    "id": 3,
    "name": "role3",
    "permissions": [
        {
            "id": 3,
            "name": "permission3"
        }
    ]
}

//Bulk POST
var role_permission = [
    {
        "id": 1,
        "name": "role1",
        "permissions": [
            {
                "id": 1,
                "name": "permission1"
            },
            {
                "id": 2,
                "name": "permission2"
            },
            {
                "id": 3,
                "name": "permission3"
            }
        ]
    },
    {
        "id": 2,
        "name": "role2",
        "permissions": [
            {
                "id": 2
            }
        ]
    },
    {
        "id": 3,
        "name": "role3",
        "permissions": [
            {
                "id": 3,
                "name": "permission3"
            }
        ]
    }
]

//--------------------------------------------------------------------------------
// User 저장
//--------------------------------------------------------------------------------
// POST
/*
 Hibernate: insert into user (id, password, role_id, username) values (null, ?, ?, ?)
 */
var step1 = [
    {
        "username": "user1",
        "password": "user1",
        "role": {
            "id": 1,
            "name": "role1",
            "permissions": [
                {
                    "id": 1,
                    "name": "permission1"
                },
                {
                    "id": 2,
                    "name": "permission2"
                },
                {
                    "id": 3,
                    "name": "permission3"
                }
            ]
        }
    }
]


// role 정보는 id 만 주어도 설정 가능하다.
var step1 = [
    {
        "username": "user2",
        "password": "user2",
        "role": {
            "id": 2
        }
    }
]

var step1 = [
    {
        "username": "user3",
        "password": "user3",
        "role": {
            "id": 3,
            "name": "role3"
        }
    }
]

var step1 = [
    {
        "username": "user4",
        "password": "user4",
        "role": {
            "id": 3,
            "name": "role3"
        }
    }
]


var step1 = [
    {
        "username": "user5",
        "password": "user5",
        "role": {
            "id": 3
        }
    }
]


// Bulk POST
var user_role = [
    {
        "username": "user1",
        "password": "user1",
        "firstName": "user1",
        "lastName": "BO",
        "role": {
            "id": 1,
            "name": "role1",
            "permissions": [
                {
                    "id": 1,
                    "name": "permission1"
                },
                {
                    "id": 2,
                    "name": "permission2"
                },
                {
                    "id": 3,
                    "name": "permission3"
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
            "id": 3,
            "name": "role3"
        }
    },
    {
        "username": "user5",
        "password": "user5",
        "firstName": "user5",
        "lastName": "BO",
        "role": {
            "id": 3
        }
    }
]

// GET
/*
 Hibernate: select user0_.id as id1_8_, user0_.password as password2_8_, user0_.role_id as role_id4_8_, user0_.username as username3_8_ from user user0_
 Hibernate: select role0_.id as id1_6_0_, role0_.name as name2_6_0_ from role role0_ where role0_.id=?
 Hibernate: select permission0_.role_id as role_id1_6_0_, permission0_.permission_id as permissi2_7_0_, permission1_.id as id1_3_1_, permission1_.name as name2_3_1_ from role_permission permission0_ inner join permission permission1_ on permission0_.permission_id=permission1_.id where permission0_.role_id=?
 */
