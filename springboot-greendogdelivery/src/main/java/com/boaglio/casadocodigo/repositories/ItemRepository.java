package com.boaglio.casadocodigo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.boaglio.casadocodigo.model.Item;

@RepositoryRestResource(collectionResourceRel="itens", path="itens")
public interface ItemRepository extends JpaRepository<Item, Long> {

}
