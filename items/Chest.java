package items;
import java.util.Random;

public class Chest {

	int itemRoll;
	Item openedItem;
	
	public Chest(){
		openChest();
	}


	//Draws random item and returns	
	public void openChest() {
		Random rand = new Random();
		itemRoll = rand.nextInt(10);
		
		switch (itemRoll) {
		case 0:
			openedItem = new RustySword();
			break;
		case 1:
			openedItem = new IronSword();
			break;
		case 2:
			openedItem = new SteelSword();
			break;
		case 3:
			openedItem = new JadeStaff();
			break;
		case 4:
			openedItem = new AmethystStaff();
			break;
		case 5:
			openedItem = new SapphireStaff();
			break;
		case 6:
			openedItem = new HealthPotion();
			break;
		case 7:
			openedItem = new StrengthPotion();
			break;
		case 8:
			openedItem = new MagicPotion();
			break;
		case 9:
			openedItem = new GodPotion();
			break;
		}
		rand = null;
	}
	
	
	//returns the item stored at initialization
	public Item getItem() {
		return (openedItem);
	}
	
	public String getInfo() {
		String info = openedItem.getName();	
		
		return (info);
	}
}
