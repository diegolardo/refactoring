package com.gildedrose;

class GildedRose {
	public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
	public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
	public static final String AGED_BRIE = "Aged Brie";
	Item[] items;

	public GildedRose(Item[] items) {
		this.items = items;
	}

	public void updateQuality() {
		for (int i = 0; i < items.length; i++) {
			if (!AGED_BRIE.equals(items[i].name) && !BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(items[i].name)
					&& items[i].quality > 0 && !SULFURAS_HAND_OF_RAGNAROS.equals(items[i].name)) {
					--items[i].quality;
			} else {
				if (items[i].quality < 50 && BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(items[i].name) && items[i].sellIn < 11) {
						++items[i].quality;
						if (items[i].sellIn < 6) {
							++items[i].quality;
						}
					}
				++items[i].quality;
			}

			if (!SULFURAS_HAND_OF_RAGNAROS.equals(items[i].name)) {
				--items[i].sellIn;
			}
			items[i] = checksellIn(items[i]);
		
		}
	}
	
	public Item checksellIn(Item item){
		if (item.sellIn < 0) {
			if (!AGED_BRIE.equals(item.name)
					&& !BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT.equals(item.name)) {
				if (item.quality > 0 && !SULFURAS_HAND_OF_RAGNAROS.equals(item.name)) {
						--item.quality;
				} else {
					item.quality = item.quality - item.quality;
				}
			} else {
				if (item.quality < 50) {
					++item.quality;
				}
			}
		}
		return item;
	}
}