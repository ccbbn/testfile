package EZ.nomargin.web;

import EZ.nomargin.domain.Item;
import EZ.nomargin.domain.ItemType;
import EZ.nomargin.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;




@Controller
@RequestMapping("/form/items")
@RequiredArgsConstructor
public class BasicItemController {
    private final ItemService itemService;
    @ModelAttribute("itemTypes")
    public ItemType[] itemTypes() { return ItemType.values();}


    @GetMapping
    public ModelAndView items() {
        List<Item> items = itemService.findTop();
        ModelAndView mav = new ModelAndView("/form/itemList")
                .addObject("items", items);
        return mav;
    }


    @ModelAttribute("ItemType")
    public ItemType[] ItemTypes() {
        return ItemType.values();
    }


    @PostConstruct  // 생성 이후 얘를 실행

        public void initProducts() {
            itemService.save(new Item("티샤스", "이것은 흰티",10000,100, ItemType.Top));
            itemService.save(new Item("바지", "키커보이는 바지",25000, 50,ItemType.Bottom));
            itemService.save(new Item("아우터", "예쁜 가디건",35000, 200, ItemType.Bottom));







    }


}
