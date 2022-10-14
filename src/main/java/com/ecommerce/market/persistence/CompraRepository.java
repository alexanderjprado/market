package com.ecommerce.market.persistence;

import com.ecommerce.market.domain.Purchase;
import com.ecommerce.market.domain.repository.IPurchaseRepository;
import com.ecommerce.market.persistence.entity.Compra;
import com.ecommerce.market.persistence.entity.crud.ICompraCrudRepository;
import com.ecommerce.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements IPurchaseRepository {

    @Autowired
    private ICompraCrudRepository iCompraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) iCompraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return iCompraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPurchase(iCompraCrudRepository.save(compra));
    }
}