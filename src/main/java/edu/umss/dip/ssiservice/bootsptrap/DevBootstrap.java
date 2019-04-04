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


    public DevBootstrap(CategoryRepository categoryRepository, SubCategoryRepository subCategoryRepository,
            ItemRepository itemRepository) {
        this.categoryRepository = categoryRepository;
        this.subCategoryRepository = subCategoryRepository;
        this.itemRepository = itemRepository;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        /* ==== CATEGORIAS === */

        // BC category
        Category bcCategory = new Category();
        bcCategory.setCode("BC");
        bcCategory.setName("BOBCATS");
        categoryRepository.save(bcCategory);

        //  EXC category
        Category excHorqCategory = new Category();
        excHorqCategory.setCode("EXC");
        excHorqCategory.setName("EXCAVADORAS");
        categoryRepository.save(excHorqCategory);

        // LLANT category
        Category llantCategory = new Category();
        llantCategory.setCode("LLANT");
        llantCategory.setName("LLANTAS");
        categoryRepository.save(llantCategory);

        // TRAC category
        Category tracCategory = new Category();
        tracCategory.setCode("TRAC");
        tracCategory.setName("TRACTORES");
        categoryRepository.save(tracCategory);

        /* ==== SUBCATEGORIAS === */

        // S-BC subcategory
        SubCategory sbcSubCategory = new SubCategory();
        sbcSubCategory.setCategory(bcCategory);
        sbcSubCategory.setCode("S-BC");
        sbcSubCategory.setName("s-bobcats");
        subCategoryRepository.save(sbcSubCategory);

        // S-EXC material subcategory
        SubCategory sexcSubCategory = new SubCategory();
        sexcSubCategory.setCategory(excHorqCategory);
        sexcSubCategory.setCode("S-EXC");
        sexcSubCategory.setName("s-escavadoras");
        subCategoryRepository.save(sexcSubCategory);

        // S-LLANT material subcategory
        SubCategory sllantSubCategory = new SubCategory();
        sllantSubCategory.setCategory(llantCategory);
        sllantSubCategory.setCode("S-LLANT");
        sllantSubCategory.setName("s-llantas");
        subCategoryRepository.save(sllantSubCategory);

        // S-TRAC material subcategory
        SubCategory stracSubCategory = new SubCategory();
        stracSubCategory.setCategory(tracCategory);
        stracSubCategory.setCode("S-TRAC");
        stracSubCategory.setName("s-tractores");
        subCategoryRepository.save(stracSubCategory);

        /* ==== ITEMS === */

        // MC510 Item
        Item mc510 = new Item();
        mc510.setCode("MC747");
        mc510.setName("Mini Cargador N° 747 ");
        mc510.setPrice(125000);
        mc510.setBrand("Toyota");
        mc510.setCapacity("c1");  // c1, c2, c3
        mc510.setModel("m2");    // m1, m2, m3
        mc510.setSubCategory(sbcSubCategory);
        itemRepository.save(mc510);

        // GH168 Item
        Item gh168 = new Item();
        gh168.setCode("GH168");
        gh168.setName("Grúa Horquilla N° 168");
        gh168.setPrice(110000);
        gh168.setBrand("Kia");
        gh168.setCapacity("c3");  // c1, c2, c3
        gh168.setModel("m2");    // m1, m2, m3
        gh168.setSubCategory(sbcSubCategory);
        itemRepository.save(gh168);

    }
}
