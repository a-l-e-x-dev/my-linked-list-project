package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

class MyLinkedListTest {

    private MyLinkedList<String> list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
    }

    // Тесты для size()

    @Test
    void size_shouldReturnZeroWhenListIsEmpty() {
        assertEquals(0, list.size());
    }

    @Test
    void size_shouldIncreaseWhenAddingElements() {
        list.addFirst("A");
        assertEquals(1, list.size());

        list.addLast("B");
        assertEquals(2, list.size());
    }

    @Test
    void size_shouldDecreaseWhenRemovingElements() {
        list.addLast("A");
        list.addLast("B");
        list.removeFirst();

        assertEquals(1, list.size());
    }

    // Тесты для addFirst()

    @Test
    void addFirst_shouldAddElementToBeginning() {
        list.addFirst("B");
        list.addFirst("A");

        assertEquals("A", list.getFirst());
        assertEquals(2, list.size());
    }

    @Test
    void addFirst_shouldWorkOnEmptyList() {
        list.addFirst("A");

        assertEquals("A", list.getFirst());
        assertEquals("A", list.getLast());
        assertEquals(1, list.size());
    }

    @Test
    void addFirst_shouldMaintainCorrectLinks() {
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    // Тесты для addLast()

    @Test
    void addLast_shouldAddElementToEnd() {
        list.addLast("A");
        list.addLast("B");

        assertEquals("B", list.getLast());
        assertEquals(2, list.size());
    }

    @Test
    void addLast_shouldWorkOnEmptyList() {
        list.addLast("A");

        assertEquals("A", list.getFirst());
        assertEquals("A", list.getLast());
        assertEquals(1, list.size());
    }

    @Test
    void addLast_shouldMaintainCorrectLinks() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    // Тесты для add(int index, E el)

    @Test
    void addAtIndex_shouldAddElementAtSpecifiedPosition() {
        list.addLast("A");
        list.addLast("C");
        list.add(1, "B");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void addAtIndex_shouldAddAtBeginning() {
        list.addLast("B");
        list.add(0, "A");

        assertEquals("A", list.getFirst());
        assertEquals("B", list.getLast());
    }

    @Test
    void addAtIndex_shouldAddAtEnd() {
        list.addLast("A");
        list.add(1, "B");

        assertEquals("A", list.getFirst());
        assertEquals("B", list.getLast());
    }

    @Test
    void addAtIndex_shouldThrowExceptionForNegativeIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(-1, "A");
        });
    }

    @Test
    void addAtIndex_shouldThrowExceptionForIndexGreaterThanSize() {
        list.addLast("A");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(2, "B");
        });
    }

    //  Тесты для getFirst()

    @Test
    void getFirst_shouldReturnFirstElement() {
        list.addLast("A");
        list.addLast("B");

        assertEquals("A", list.getFirst());
    }

    @Test
    void getFirst_shouldThrowExceptionWhenListIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            list.getFirst();
        });
    }

    // Тесты для getLast()

    @Test
    void getLast_shouldReturnLastElement() {
        list.addLast("A");
        list.addLast("B");

        assertEquals("B", list.getLast());
    }

    @Test
    void getLast_shouldThrowExceptionWhenListIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            list.getLast();
        });
    }

    // Тесты для get(int index)

    @Test
    void get_shouldReturnCorrectElement() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
    }

    @Test
    void get_shouldThrowExceptionForNegativeIndex() {
        list.addLast("A");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-1);
        });
    }

    @Test
    void get_shouldThrowExceptionForIndexEqualToSize() {
        list.addLast("A");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1);
        });
    }

    @Test
    void get_shouldThrowExceptionForIndexGreaterThanSize() {
        list.addLast("A");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(2);
        });
    }

    @Test
    void get_shouldThrowExceptionOnEmptyList() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

    // Тесты для removeFirst()

    @Test
    void removeFirst_shouldRemoveAndReturnFirstElement() {
        list.addLast("A");
        list.addLast("B");

        assertEquals("A", list.removeFirst());
        assertEquals("B", list.getFirst());
        assertEquals(1, list.size());
    }

    @Test
    void removeFirst_shouldThrowExceptionWhenListIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            list.removeFirst();
        });
    }

    @Test
    void removeFirst_shouldWorkOnSingleElementList() {
        list.addLast("A");

        assertEquals("A", list.removeFirst());
        assertEquals(0, list.size());
    }

    @Test
    void removeFirst_shouldUpdateHeadCorrectly() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        list.removeFirst();

        assertEquals("B", list.getFirst());
        assertEquals("C", list.getLast());
    }

    // Тесты для removeLast()

    @Test
    void removeLast_shouldRemoveAndReturnLastElement() {
        list.addLast("A");
        list.addLast("B");

        assertEquals("B", list.removeLast());
        assertEquals("A", list.getLast());
        assertEquals(1, list.size());
    }

    @Test
    void removeLast_shouldThrowExceptionWhenListIsEmpty() {
        assertThrows(NoSuchElementException.class, () -> {
            list.removeLast();
        });
    }

    @Test
    void removeLast_shouldWorkOnSingleElementList() {
        list.addLast("A");

        assertEquals("A", list.removeLast());
        assertEquals(0, list.size());
    }

    @Test
    void removeLast_shouldUpdateTailCorrectly() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        list.removeLast();

        assertEquals("A", list.getFirst());
        assertEquals("B", list.getLast());
    }

    // Тесты для remove(int index)

    @Test
    void removeAtIndex_shouldRemoveAndReturnElement() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        assertEquals("B", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("A", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    void removeAtIndex_shouldRemoveFirstElement() {
        list.addLast("A");
        list.addLast("B");

        assertEquals("A", list.remove(0));
        assertEquals("B", list.getFirst());
    }

    @Test
    void removeAtIndex_shouldRemoveLastElement() {
        list.addLast("A");
        list.addLast("B");

        assertEquals("B", list.remove(1));
        assertEquals("A", list.getLast());
    }

    @Test
    void removeAtIndex_shouldThrowExceptionForNegativeIndex() {
        list.addLast("A");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(-1);
        });
    }

    @Test
    void removeAtIndex_shouldThrowExceptionForIndexEqualToSize() {
        list.addLast("A");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(1);
        });
    }

    // Комплексные тесты

    @Test
    void complexScenario_shouldWorkCorrectly() {
        // Создаем список: [A, B, C, D]
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.addLast("D");

        assertEquals(4, list.size());

        // Удаляем первый и последний
        assertEquals("A", list.removeFirst());
        assertEquals("D", list.removeLast());

        assertEquals(2, list.size());
        assertEquals("B", list.getFirst());
        assertEquals("C", list.getLast());

        // Добавляем в середину
        list.add(1, "X");

        assertEquals(3, list.size());
        assertEquals("B", list.get(0));
        assertEquals("X", list.get(1));
        assertEquals("C", list.get(2));

        // Удаляем из середины
        assertEquals("X", list.remove(1));

        assertEquals(2, list.size());
        assertEquals("B", list.get(0));
        assertEquals("C", list.get(1));
    }

    @Test
    void testWithIntegerType() {
        MyLinkedList<Integer> intList = new MyLinkedList<>();

        intList.addLast(1);
        intList.addLast(2);
        intList.addLast(3);

        assertEquals(3, intList.size());
        assertEquals(1, intList.getFirst());
        assertEquals(3, intList.getLast());
        assertEquals(2, intList.get(1));
    }

    @Test
    void testWithMixedOperations() {
        // Начинаем с пустого списка
        assertEquals(0, list.size());

        // Добавляем элементы разными способами
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("D");
        list.add(2, "C");

        // Проверяем состояние: [A, B, C, D]
        assertEquals(4, list.size());
        assertEquals("A", list.get(0));
        assertEquals("B", list.get(1));
        assertEquals("C", list.get(2));
        assertEquals("D", list.get(3));

        // Удаляем элементы разными способами
        assertEquals("A", list.removeFirst());
        assertEquals("D", list.removeLast());
        assertEquals("C", list.remove(1));

        // Проверяем конечное состояние: [B]
        assertEquals(1, list.size());
        assertEquals("B", list.getFirst());
        assertEquals("B", list.getLast());
    }

    @Test
    void testEdgeCases() {
        // Тест 1: Добавление и удаление одного элемента
        list.addFirst("Single");
        assertEquals("Single", list.removeFirst());
        assertEquals(0, list.size());

        // Тест 2: Добавление в начало после очистки
        list.addLast("New");
        assertEquals(1, list.size());

        // Тест 3: Многократное добавление/удаление
        for (int i = 0; i < 5; i++) {
            list.addLast("Element" + i);
        }
        assertEquals(6, list.size());

        while (list.size() > 0) {
            list.removeFirst();
        }
        assertEquals(0, list.size());
    }
}