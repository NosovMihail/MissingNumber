import java.util.*;

public class MissingNumber {

    public Integer findMissingNumberInArray(Integer[] inputSequence) {
        if(inputSequence.length == 0){ //Проверяем, что массив не пустой
            return null;
        }
        ArrayList<Integer> sequenceList = new ArrayList<>(Arrays.asList(inputSequence));
        HashSet<Integer> sequenceSet = new HashSet<>(sequenceList); //Удаляем повторяющиеся элементы
        sequenceList.clear();
        sequenceList.addAll(sequenceSet);
        /* Если повторяющиеся элементы - некорректное поведение, то нужно снять этот комментарий и отредактировать тесты
        if(sequenceSet.size() != sequenceList.size()){
            return null;
        }
        */
        Collections.sort(sequenceList); //Сортируем последовательность
        int firstElement = sequenceList.get(0); //Сдвиг последовательности относительно индексов массива
        for(int i = 1; i < sequenceList.size(); i++){ //Ищем элемент, который не совпадает со своим индексом
            if(sequenceList.get(i) - firstElement != i){
                return i + firstElement; //Возвращаем индекс пропущенного элемента + сдвиг
            }
        }
        return null; //Вместо null можно возвращать ошибку
    }

    public Integer findMissingNumberInArray(String inputSequence) { //Перегрузка метода для поддержки строкового ввода
        String[] splitInput = inputSequence.replace("[", "").replace("]", "").split(",");
        Integer[] integerSequence = new Integer[splitInput.length];
        try {
            for(int i = 0; i < splitInput.length; i++){
                integerSequence[i] = Integer.parseInt(splitInput[i].trim());
            }
        }catch (NumberFormatException e){
            return null; //Стоит добавить логгирование или возвращать ошибку
        }
        return findMissingNumberInArray(integerSequence);
    }

}
