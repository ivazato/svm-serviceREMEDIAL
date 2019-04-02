/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.dip.ssiservice.bootsptrap;

import edu.umss.dip.ssiservice.model.*;
import edu.umss.dip.ssiservice.repositories.*;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private CategoryRepository categoryRepository;
    private SubCategoryRepository subCategoryRepository;
    private ItemRepository itemRepository;
    //private EmployeeRepository employeeRepository;
    //private PositionRepository positionRepository;
    //private ContractRepository contractRepository;

    public DevBootstrap(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository,
            ItemRepository itemRepository /*, EmployeeRepository employeeRepository,*/
            /*PositionRepository positionRepository,*/ /*ContractRepository contractRepository*/) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.itemRepository = itemRepository;
//        this.employeeRepository = employeeRepository;
        //this.positionRepository = positionRepository;
        //this.contractRepository = contractRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        // GRUHOR category
        Category gruHorqCategory = new Category();
        gruHorqCategory.setCode("GRUHOR");
        gruHorqCategory.setName("GRUAS HORQUILLA");
        categoryRepository.save(gruHorqCategory);

        // BC category
        Category bcCategory = new Category();
        bcCategory.setCode("BC");
        bcCategory.setName("BOBCATS");
        categoryRepository.save(bcCategory);

        // bc1 subcategory
        SubCategory bc1SubCategory = new SubCategory();
        bc1SubCategory.setCategory(gruHorqCategory);
        bc1SubCategory.setCode("BC1");
        bc1SubCategory.setName("BobCats1");
        subCategoryRepository.save(bc1SubCategory);

        // bc2 material subcategory
        SubCategory bc2SubCategory = new SubCategory();
        bc2SubCategory.setCategory(bcCategory);
        bc2SubCategory.setCode("BC2");
        bc2SubCategory.setName("BobCats2");
        subCategoryRepository.save(bc2SubCategory);

        // MC510 Item
        Item mc510 = new Item();
        mc510.setCode("MC510");
        mc510.setName("Mini Cargador N° 510 ");
        mc510.setPrice("125000");
        mc510.setSubCategory(bc1SubCategory);
        itemRepository.save(mc510);

        // GH168 Item
        Item gh168 = new Item();
        gh168.setCode("GH168");
        gh168.setName("Grúa Horquilla N° 168");
        gh168.setPrice("110000");
        gh168.setSubCategory(bc2SubCategory);
        itemRepository.save(gh168);
/*
        // John Employee
        Employee john = new Employee();
        john.setFirstName("John");
        john.setLastName("Doe");
*/
/*
        // Position
        Position position = new Position();
        position.setName("OPERATIVE");
        positionRepository.save(position);
*/
/*
        // contract
        Contract contract = new Contract();
        contract.setEmployee(john);
        contract.setInitDate(new Date(2010, 1, 1));
        /*contract.setPosition(position);*/
/*
        john.getContracts().add(contract);
        employeeRepository.save(john);
        //contractRepository.save(contract);
*/
    }
}
