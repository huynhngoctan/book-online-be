package com.nlu.bookonlinebe.databases;

import com.nlu.bookonlinebe.models.Order;
import com.nlu.bookonlinebe.models.OrderDetail;
import com.nlu.bookonlinebe.models.Product;
import com.nlu.bookonlinebe.models.User;
import com.nlu.bookonlinebe.repositories.OrderDetailRepository;
import com.nlu.bookonlinebe.repositories.OrderRepository;
import com.nlu.bookonlinebe.repositories.ProductRepository;
import com.nlu.bookonlinebe.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class Database {
    @Bean
    public CommandLineRunner initDatabase(UserRepository userRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user1 = new User("admin", "admin", "admin@gmail.com", "hello", new Date("01/02/2000"),
                        "0945258369", "Ho Chi Minh", "admin", "Kích hoạt", "https://lh3.googleusercontent.com/ogw/ADea4I7wyN6WgGDhKr7mh08qsgwi0O2_3kg9d3XzCMuR=s32-c-mo");
                User user2 = new User("tan123", "tan123", "tan123@gmail.com", "tan huynh", new Date("02/03/2000"),
                        "0945258123", "Ben Tre", "user", "Kích hoạt", "https://lh3.googleusercontent.com/ogw/ADea4I7wyN6WgGDhKr7mh08qsgwi0O2_3kg9d3XzCMuR=s32-c-mo");
                User user3 = new User("teo", "teo", "teo@gmail.com", "Nguyen Van Teo", new Date("03/04/2000"),
                        "0945258789", "Ca Mau", "user", "Kích hoạt", "https://lh3.googleusercontent.com/ogw/ADea4I7wyN6WgGDhKr7mh08qsgwi0O2_3kg9d3XzCMuR=s32-c-mo");

                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
            }
        };
    }

    @Bean
    public CommandLineRunner initProducts(ProductRepository productRepository, OrderDetailRepository orderDetailRepository, OrderRepository orderRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Product product1 = new Product("Nhà giả kim", "Paulo Coelho", "NXB Kim Đồng", 1988, "Tiểu thuyết"
                        , 100, 150, "Mở bán", "Đây là một cuốn sách rất hay", 1400, 25000,"http://isach.info/images/story/cover/nha_gia_kim__paulo_coelho.jpg");
                Product product2 = new Product("Đắc nhân tâm", "Paulo Coelho", "NXB Hội nhà văn", 2000, "Làm giàu"
                        , 100, 150, "Mở bán", "Đây là một cuốn sách rất hay", 1400, 25000,"http://isach.info/images/story/cover/nha_gia_kim__paulo_coelho.jpg");
                Product product3 = new Product("Cafe cùng tony", "Paulo Coelho", "NXB Kim Đồng", 1988, "Tiểu thuyết"
                        , 100, 150, "Mở bán", "Đây là một cuốn sách rất hay", 1400, 25000,"http://isach.info/images/story/cover/nha_gia_kim__paulo_coelho.jpg");

                Order order1 = new Order("Huynh Ngoc Tan","Ho Chi Minh","0848107178",new Date("01/02/2022"),"Chưa thanh toán","Đơn hàng mới",30000);

                OrderDetail orderDetail1 = new OrderDetail(order1,product1,3);
                OrderDetail orderDetail2 = new OrderDetail(order1,product2,1);
                OrderDetail orderDetail3 = new OrderDetail(order1,product3,5);

                productRepository.save(product1);
                productRepository.save(product2);
                productRepository.save(product3);

                orderRepository.save(order1);
                orderDetailRepository.save(orderDetail1);
                orderDetailRepository.save(orderDetail2);
                orderDetailRepository.save(orderDetail3);
            }
        };
    }
}
