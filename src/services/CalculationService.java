package services;

import java.util.List;

public class CalculationService {

	public static <T extends Comparable<T>> T max(List<T> list) {

		if (list.isEmpty()) {
			throw new IllegalStateException("Lista n�o pode estar vazia");
		}

		T max = list.get(0);

		for (T item : list) {
			if (item.compareTo(max) > 0) { //comparando os valores
				max = item; //adcionando o maior valor
			}
		}
		return max;
	}

}
