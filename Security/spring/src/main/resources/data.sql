INSERT INTO TBL_ROLE
(name)
VALUES ('role1'), ('role2'), ('role3'), ('role4'), ('role5'), ('role6');


INSERT INTO TBL_PERMISSION
(name)
VALUES
('state.product.search'), ('state.product.detail'), ('state.product.register'),
('state.product.orderSearch'), ('state.product.orderRegister'), ('state.product.orderDetail'),
('state.order.search'), ('state.order.returnSearch'), ('state.order.rejectSearch'),
('state.member.search'),

('action.search.product'),
('action.search.plorder'),
('action.search.member'),
('action.search.order'),
('action.search.orderReturn'),
('action.search.orderReject'),

('action.approve.product'),
('action.approve.plorder'),

('action.register.product'),
('action.register.plorder'),

('action.update.product'),
('action.update.plorder'),

('READ'),
('WRITE'),
('UPDATE'),
('DELETE');




