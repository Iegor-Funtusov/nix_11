package ua.com.alevel.reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReferenceTest {

    public void test() {
        List<Integer> list = Arrays.asList(1, 3);

        List<Integer> list1 = list
                .stream()
                .map(i -> sum(i, 9))
                .collect(Collectors.toList());
        System.out.println("list = " + list);
        list1 = list
                .stream()
                .map(this::sum1) // 1
                .collect(Collectors.toList());

        list1 = list
                .stream()
                .map(MathUtil::sum1) // 2
                .collect(Collectors.toList());

        list1 = list
                .stream()
                .map(Integer::reverseBytes) // 3
                .collect(Collectors.toList());

        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setAge(50);
        customer.setCreated(new Date());
        customer.setFirstName("first");
        customer.setLastName("last");
        customer.setId(UUID.randomUUID().toString());
        customers.add(customer);
        System.out.println("customers = " + customers);

        List<CustomerConverter> customersConverters = new ArrayList<>();
        for (Customer customer1 : customers) {
            CustomerConverter customerConverter = new CustomerConverter();
            customerConverter.setAge(customer1.getAge());
            customerConverter.setCreated(customer1.getCreated().toString());
            customerConverter.setFullName(customer1.getFirstName() + " " + customer1.getLastName());
            customerConverter.setId(customer1.getId());
            customersConverters.add(customerConverter);
        }
        System.out.println("customersConverters = " + customersConverters);


        customersConverters = customers.stream().
                map(customer2 -> {
                    CustomerConverter customerConverter = new CustomerConverter();
                    customerConverter.setAge(customer2.getAge());
                    customerConverter.setCreated(customer2.getCreated().toString());
                    customerConverter.setFullName(customer2.getFirstName() + " " + customer2.getLastName());
                    customerConverter.setId(customer2.getId());
                    return customerConverter;
                })
                .collect(Collectors.toList());

        customersConverters = customers.stream().
                map(CustomerConverter::new)
                .collect(Collectors.toList());

        List<CustomerConverterNew> customerConverterNews = customers.
                stream().
                map(CustomerConverter::new).
                map(CustomerConverterNew::new).
                collect(Collectors.toList());

        System.out.println("customerConverterNews = " + customerConverterNews);
    }

    public int sum1(int a) {
        return a + 10;
    }

    public int sum(int a, int b) {
        return a + b;
    }
}
