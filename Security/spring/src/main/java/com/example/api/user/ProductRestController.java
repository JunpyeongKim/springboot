package com.example.api.user;


import com.example.domain.user.Member;
import com.example.domain.user.Product;
import com.example.repository.user.MemberRepository;
import com.example.repository.user.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("products")
public class ProductRestController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    MemberRepository memberRepository;

    @RequestMapping(method = RequestMethod.POST)
    public List<Product> postProducts(@RequestBody List<Product> products) {
        List<Product> created = productRepository.save(products);
        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Product> getProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable String id) {
        Product product = productRepository.findOne(id);
        return product;
    }

    //TODO: necessary ???
    @RequestMapping(method = RequestMethod.PUT)
    public List<Product> putProducts(@RequestBody List<Product> products) {
        List<Product> updated = productRepository.save(products);
        return updated;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Product putProduct(@PathVariable String id,
                              @RequestBody Product product) {
        Product found = productRepository.findOne(id);
        Product updated = null;

        if (found != null) {
            updated = productRepository.save(product);
        }

        return updated;
    }

    //TODO: necessary ??? --> a little
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteProducts() {
        productRepository.deleteAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String id) {
        //TODO: handling unfound id


        // and then delete a specific id

        // Member 에서 삭제
        // product 사용중인 Member 검색후 Member 업데이트
        // 이후 product 삭제
        List<Member> members = memberRepository.findAll();

        members.forEach(member -> {
            List<Product> products = member.getProducts();
            List<Product> updated = new ArrayList<Product>();
            for (Product product : products) {
                if (!product.getId().equals(id)) {
                    updated.add(product);
                }
            }
            products.clear();
            products.addAll(updated);
        });

        List<Member> updated = memberRepository.save(members);


        // 이후 Product 삭제 가능
        productRepository.delete(id);
    }
}
