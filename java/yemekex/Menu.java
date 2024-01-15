package yemekex;

import java.util.ArrayList;

public class Menu extends ArrayList<Food> {
    private static Menu menu;

    public Menu(int capacity) {
        super(capacity);
    }
    private Menu () {
    add(new Food("Bol Malzemos",3000));
    add(new Food("Kasarli",2000));
    add(new Food("Sucuklu",2500));
    add(new Food("Mantarli",2000));
    add(new Food("Peynirli",2000));
    add(new Food("Karisik",3000));
    add(new Food("Pastirma & Sucuk",3000));
    add(new Food("Bol Etli",3500));
    add(new Food("Üç Peynirli",3500));
    add(new Food("Tavuklu",1500));
    add(new Food("Margarita",3500));
    add(new Food("Sosyal",1500));
    add(new Food("taze",1000));
    add(new Food("Barbeque",3500));
    add(new Food("mangal sucuk",2500));
    add(new Food("Vegi",2000));
    add(new Food("FAvori",2000));
    add(new Food("Italiano",3500));
    add(new Food("Süperos",1500));
    add(new Food("Süperix",1000));
    add(new Food("Ocakbaşi",3000));
    add(new Food("Balli HardalliTavuklu",2000));
    add(new Food("işkembe",1000));
    add(new Food("Favori İkili",3000));
    add(new Food("Sucuksever",1000));
    add(new Food("Peperonni",3000));
    add(new Food("Cheddarli Dev Sosisli",300));
    add(new Food("SArimsak Soslu Sucuksever",1000));
    add(new Food("Kantin",3000));

}
public static Menu getAllFood() {
    if (menu == null)
        return menu;
    else
        return menu = new Menu();    
}
}

