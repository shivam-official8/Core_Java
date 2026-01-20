INSERT INTO product (name, desc, brand, price, category, release_date) VALUES
                                                                             ('Smartphone X', 'Latest flagship smartphone', 'TechCorp', 799.99, 'Electronics', '2025-10-01'),
                                                                             ('Laptop Pro', 'High performance laptop', 'CompTech', 1299.50, 'Computers', '2025-08-15'),
                                                                             ('Wireless Earbuds', 'Noise-cancelling earbuds', 'SoundMax', 149.99, 'Audio', '2025-09-10'),
                                                                             ('Gaming Console', 'Next-gen gaming console', 'GameWorld', 499.00, 'Gaming', '2025-11-20'),
                                                                             ('Smartwatch S', 'Fitness and notifications', 'TechCorp', 199.99, 'Wearables', '2025-07-05'),
                                                                             ('4K TV', 'Ultra HD Smart TV', 'ViewPlus', 999.00, 'Electronics', '2025-06-30'),
                                                                             ('Bluetooth Speaker', 'Portable speaker', 'SoundMax', 89.99, 'Audio', '2025-08-25'),
                                                                             ('E-reader', 'Read books digitally', 'ReadTech', 129.00, 'Gadgets', '2025-09-15'),
                                                                             ('Fitness Tracker', 'Track steps & sleep', 'FitLife', 79.99, 'Wearables', '2025-07-20'),
                                                                             ('Tablet Z', 'Lightweight and powerful', 'CompTech', 599.50, 'Computers', '2025-10-10');

-- it will give error cause it will try to insert in table evnthought table is not created at that time
-- so for that we have to do spring.jpa.defer-datasource-initialization=true in application.properties