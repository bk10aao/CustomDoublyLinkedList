import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomDoublyLinkedListTest {

    @Test
    public void givenNewEmptyList_returnsSizeOf_0() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertEquals(0, customDoublyLinkedList.size());
    }

    @Test
    public void givenConstructorWithCollectionParameter_onNullCollection_throws_NullPointerException() {
        assertThrows(NullPointerException.class, () -> new CustomDoublyLinkedList<Integer>(null));
    }

    @Test
    public void givenConstructorWithCollectionParameter_onCollectionOf_0_1_2_3_4_containsValues_withSizeOf_5() {
        Collection<Integer> values = new ArrayList<>();
        for(int i = 0; i < 5; i++)
            values.add(i);
        CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>(values);
        assertTrue(list.contains(0));
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertTrue(list.contains(4));
        assertEquals(5, list.size());
    }

    @Test
    public void givenLinkedListOfType_Integer_onAdding_1_returnsSizeOf_1() {
        CustomDoublyLinkedList<Integer> customLinkedList = new CustomDoublyLinkedList<>();
        customLinkedList.add(1);
        assertEquals(1, customLinkedList.size());
    }

    @Test
    public void givenLinkedListOfType_Integer_onAdding_1_2_returnsSizeOf_2() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertEquals(1, customDoublyLinkedList.size());
        assertTrue(customDoublyLinkedList.add(2));
        assertEquals(2, customDoublyLinkedList.size());
    }

    @Test
    public void givenNewListOf_10_onAddLast_20_returnsSizeOf_2() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.addFirst(10);
        customDoublyLinkedList.add(20);
        assertEquals(2, customDoublyLinkedList.size());
        assertEquals(20, customDoublyLinkedList.get(1));
    }

    @Test
    public void givenNewList_onRemove_throws_NoSuchElementException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertThrows(NoSuchElementException.class, customDoublyLinkedList::remove);
    }

    @Test
    public void givenNewListOf_10_20_30_on_remove_returns_10_andSizeOf_2() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(3, customDoublyLinkedList.size());
        assertEquals(10, customDoublyLinkedList.remove());
        assertEquals(2, customDoublyLinkedList.size());
    }

    @Test
    public void givenNewList_onRemoveFirst_throws_NoSuchElementException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertThrows(NoSuchElementException.class, customDoublyLinkedList::removeFirst);
    }

    @Test
    public void givenNewListOf_10_20_30_on_removeFirst_returns_10_andSizeOf_2() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(3, customDoublyLinkedList.size());
        assertEquals(10, customDoublyLinkedList.removeFirst());
        assertEquals(2, customDoublyLinkedList.size());
    }

    @Test
    public void givenNewList_onRemoveLast_throws_NoSuchElementException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertThrows(NoSuchElementException.class, customDoublyLinkedList::removeLast);
    }

    @Test
    public void givenNewListOf_10_20_30_on_removeLast_returns_30_andSizeOf_2() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(3, customDoublyLinkedList.size());
        assertEquals(30, customDoublyLinkedList.removeLast());
        assertEquals(2, customDoublyLinkedList.size());
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_0_adds_100_toStart() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        customDoublyLinkedList.add(0, 100);
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_0_adds_100_toIndex_0() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        customDoublyLinkedList.add(0, 100);
        assertEquals(100, customDoublyLinkedList.get(0));
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_1_adds_100_toIndex_1() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        customDoublyLinkedList.add(1, 100);
        assertEquals(100, customDoublyLinkedList.get(1));
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_2_adds_100_toIndex_2() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        customDoublyLinkedList.add(2, 100);
        assertEquals(100, customDoublyLinkedList.get(2));
    }

    @Test
    public void givenNewListOf_10_20_30_on_add_100_toIndex_3_adds_100_toIndex_3() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        customDoublyLinkedList.add(3, 100);
        assertEquals(100, customDoublyLinkedList.get(3));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_5_throwsIndexOutOfBoundsException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customDoublyLinkedList.remove(5));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_negative_1_throwsIndexOutOfBoundsException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customDoublyLinkedList.remove(-1));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_3_returns_true() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertEquals(3, customDoublyLinkedList.remove(2));
        assertEquals(2, customDoublyLinkedList.size());
        assertEquals(1, customDoublyLinkedList.get(0));
        assertEquals(2, customDoublyLinkedList.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> customDoublyLinkedList.get(2));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_remove_1_returns_true() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertEquals(2, customDoublyLinkedList.remove(1));
        assertEquals(2, customDoublyLinkedList.size());
    }

    @Test
    public void givenEmptyLinkedListOfType_Integer_on_addLast_1_returnsSizeOf_1() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.addLast(1);
        assertEquals(1, customDoublyLinkedList.size());
    }

    @Test
    public void givenEmptyLinkedListOfType_onGet_negativeOne_throwsIndexOutOfBoundsException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertThrows(IndexOutOfBoundsException.class, () -> customDoublyLinkedList.get(-1));
    }

    @Test
    public void givenLinkedListOf3Values_onGetIndex_4_throws_indexOutOfBoundsException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(1);
        customDoublyLinkedList.add(2);
        customDoublyLinkedList.add(3);
        assertThrows(IndexOutOfBoundsException.class, () -> customDoublyLinkedList.get(4));
    }

    @Test
    public void givenLinkedListOfValue_10_20_30_onGetRelevantIndexes_returnsCorrectValues() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(10, customDoublyLinkedList.get(0));
        assertEquals(20, customDoublyLinkedList.get(1));
        assertEquals(30, customDoublyLinkedList.get(2));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toNegativeIndex_throws_indexOutOfBoundsException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertThrows(IndexOutOfBoundsException.class, () -> customDoublyLinkedList.add(-1,40));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toIndex_100_throws_indexOutOfBoundsException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertThrows(IndexOutOfBoundsException.class, () -> customDoublyLinkedList.add(100,40));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toIndex_1_returns_10_40_20_30() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        customDoublyLinkedList.add(1, 40);
        assertEquals(40, customDoublyLinkedList.get(1));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onAdd_40_toIndex_2_returns_10_20_40_30() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        customDoublyLinkedList.add(2, 40);
        assertEquals(40, customDoublyLinkedList.get(2));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_40_onAdd_50_toIndex_3_returns_10_20_30_50_40() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        customDoublyLinkedList.add(40);
        customDoublyLinkedList.add(3, 50);
        assertEquals(50, customDoublyLinkedList.get(3));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onContains_null_throws_nullPointerException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertThrows(NullPointerException.class, () -> customDoublyLinkedList.contains(null));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onContains_100_returns_false() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertFalse(customDoublyLinkedList.contains(100));
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onContains_20_returns_true() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertTrue(customDoublyLinkedList.contains(20));
    }

    @Test
    public void givenEmptyLinkedList_of_element_throws_NoSuchElementException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertThrows(NoSuchElementException.class, customDoublyLinkedList::element);
    }

    @Test
    public void givenLinkedListOfValues_10_20_30_onElement_returns_10() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(10, customDoublyLinkedList.element());
    }

    @Test
    public void givenEmptyLinkedList_onPoll_returns_null() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertNull(customDoublyLinkedList.poll());
    }

    @Test
    public void givenLinkedListOf_20_onPoll_returns_20() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(20);
        assertEquals(20, customDoublyLinkedList.poll());
        assertEquals(0, customDoublyLinkedList.size());
    }

    @Test
    public void givenLinkedListOf_10_20_30_onPoll_returns_10() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(3, customDoublyLinkedList.size());
        assertEquals(10, customDoublyLinkedList.poll());
        assertEquals(2, customDoublyLinkedList.size());
    }

    @Test
    public void givenLinkedListOf_10_20_30_onOffer_40_returns_true_andLastItemInListOf_40() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(3, customDoublyLinkedList.size());
        assertEquals(30, customDoublyLinkedList.get(customDoublyLinkedList.size() - 1));
        assertTrue(customDoublyLinkedList.offer(40));
        assertEquals(40, customDoublyLinkedList.get(customDoublyLinkedList.size() - 1));
    }

    @Test
    public void givenLinkedListOf_10_20_30_onOfferFirst_40_returns_true_andFirstItemInListOf_40_andSecondItemInListOf_10() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(3, customDoublyLinkedList.size());
        assertEquals(30, customDoublyLinkedList.get(customDoublyLinkedList.size() - 1));
        assertTrue(customDoublyLinkedList.offerFirst(40));
        assertEquals(30, customDoublyLinkedList.get(customDoublyLinkedList.size() - 1));
        assertEquals(40, customDoublyLinkedList.get(0));
        assertEquals(10, customDoublyLinkedList.get(1));
    }

    @Test
    public void givenLinkedListOf_10_20_30_onOfferLast_40_returns_true_andLastInListOf_40() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(3, customDoublyLinkedList.size());
        assertEquals(30, customDoublyLinkedList.get(customDoublyLinkedList.size() - 1));
        assertTrue(customDoublyLinkedList.offerLast(40));
        assertEquals(40, customDoublyLinkedList.get(customDoublyLinkedList.size() - 1));
        assertEquals(30, customDoublyLinkedList.get(customDoublyLinkedList.size() - 2));
    }

    @Test
    public void givenEmptyLinkedList_onPeekFirst_returns_null() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertNull(customDoublyLinkedList.peekFirst());
    }

    @Test
    public void givenLinkedListOf_10_20_30_onPeekFirst_returns_10() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(10, customDoublyLinkedList.peekFirst());
    }

    @Test
    public void givenEmptyLinkedList_onPeekLast_returns_null() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertNull(customDoublyLinkedList.peekLast());
    }

    @Test
    public void givenLinkedListOf_10_20_30_onPeekLast_returns_30() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(30, customDoublyLinkedList.peekLast());
    }

    @Test
    public void givenEmptyLinkedList_onPollFirst_returns_null() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertNull(customDoublyLinkedList.pollFirst());
    }

    @Test
    public void givenLinkedListOf_10_20_30_onPollFirst_returns_10() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(10, customDoublyLinkedList.pollFirst());
    }

    @Test
    public void givenEmptyLinkedList_on_pollLast_returns_null() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertNull(customDoublyLinkedList.pollLast());
    }

    @Test
    public void givenLinkedListOf_10_20_30_on_pollLast_returns_30() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        customDoublyLinkedList.add(10);
        customDoublyLinkedList.add(20);
        customDoublyLinkedList.add(30);
        assertEquals(30, customDoublyLinkedList.pollLast());
        assertEquals(20, customDoublyLinkedList.get(customDoublyLinkedList.size() - 1));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_push_valueOf_0_insert_zeroToStart() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        customDoublyLinkedList.push(0);
        assertEquals(0, customDoublyLinkedList.get(0));
    }

    @Test
    public void givenEmptyLinkedList_onPop_throws_NoSuchElementException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertThrows(NoSuchElementException.class, customDoublyLinkedList::pop);
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_on_pop_valueOf_0_insert_zeroToStart() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertEquals(1, customDoublyLinkedList.pop());
        assertEquals(2, customDoublyLinkedList.get(0));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_negative_1_to_40throwsIndexOutOfBoundsException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customDoublyLinkedList.set(-1, 40));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_4_to_40throwsIndexOutOfBoundsException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertThrows(IndexOutOfBoundsException.class, () -> customDoublyLinkedList.set(4, 40));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_0_to_10_updatesIndexValueTo_10() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertEquals(1,  customDoublyLinkedList.set(0, 10));
        assertEquals(10, customDoublyLinkedList.get(0));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onSetIndexOf_1_to_10_updatesIndexValueTo_10() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertEquals(2,  customDoublyLinkedList.set(1, 10));
        assertEquals(10, customDoublyLinkedList.get(1));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_4_onSetIndexOf_2_to_10_updatesIndexValueTo_10() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertTrue(customDoublyLinkedList.add(4));
        assertEquals(3,  customDoublyLinkedList.set(2, 10));
        assertEquals(10, customDoublyLinkedList.get(2));
    }

    @Test
    public void givenLinkedListOfTypeInteger_withNoValues_onToArray_returns_emptyArray() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        Object[] arr = customDoublyLinkedList.toArray();
        assertEquals(0, arr.length);
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onToArray_returnsCorrectArray() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertArrayEquals(new Integer[] { 1, 2, 3 } , customDoublyLinkedList.toArray());
    }

    @Test
    public void givenLinkedListOfType_Integer_onAddingNullCollection_throws_NullPointerException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertThrows(NullPointerException.class, () -> customDoublyLinkedList.addAll(null));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onAddAll_4_5_6_updatesListCorrectly() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        Collection<Integer> collection = new ArrayList<>();
        collection.add(4);
        collection.add(5);
        collection.add(6);
        assertTrue(customDoublyLinkedList.addAll(collection));
        assertEquals(1, customDoublyLinkedList.get(0));
        assertEquals(2, customDoublyLinkedList.get(1));
        assertEquals(3, customDoublyLinkedList.get(2));
        assertEquals(4, customDoublyLinkedList.get(3));
        assertEquals(5, customDoublyLinkedList.get(4));
        assertEquals(6, customDoublyLinkedList.get(5));
    }

    @Test
    public void givenTwoLinkedListsOfType_Integer_firstValues_1_2_3_secondValue_4_5_6_onEquals_returnsFalse() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));

        CustomDoublyLinkedList<Integer> customDoublyLinkedListTwo = new CustomDoublyLinkedList<>();
        customDoublyLinkedListTwo.add(4);
        customDoublyLinkedListTwo.add(5);
        customDoublyLinkedListTwo.add(6);
        assertNotEquals(customDoublyLinkedList, customDoublyLinkedListTwo);
    }

    @Test
    public void givenTwoLinkedListsOfType_Integer_firstValues_1_2_3_secondValue_1_2_3_onEquals_returnsTrue() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));

        CustomDoublyLinkedList<Integer> customDoublyLinkedListTwo = new CustomDoublyLinkedList<>();
        customDoublyLinkedListTwo.add(1);
        customDoublyLinkedListTwo.add(2);
        customDoublyLinkedListTwo.add(3);
        assertEquals(customDoublyLinkedList, customDoublyLinkedListTwo);
    }

    @Test
    public void givenEmptyLinkedList_onRemove_throws_NoSuchElementException() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertThrows(NoSuchElementException.class, customDoublyLinkedList::remove);
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_onRemove_returns_1() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertEquals(1, customDoublyLinkedList.remove());
        assertEquals(2, customDoublyLinkedList.peek());
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onRemoveObject_d_returns_null() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertNull(customDoublyLinkedList.remove("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onRemoveObject_b_returns_b_andRemoveItFromList() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertEquals("b", customDoublyLinkedList.remove("b"));
        assertEquals("a", customDoublyLinkedList.get(0));
        assertEquals("c", customDoublyLinkedList.get(1));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onIndexOf_d_returns_minus_1() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertEquals(-1, customDoublyLinkedList.indexOf("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onIndexOf_a_returns_0_b_1_c_2() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertEquals(0, customDoublyLinkedList.indexOf("a"));
        assertEquals(1, customDoublyLinkedList.indexOf("b"));
        assertEquals(2, customDoublyLinkedList.indexOf("c"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onLastIndexOf_d_returns_minus_1() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertEquals(-1, customDoublyLinkedList.lastIndexOf("d"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onLastIndexOf_a_returns_0() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertEquals(0, customDoublyLinkedList.lastIndexOf("a"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_onLastIndexOf_b_returns_1() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertEquals(1, customDoublyLinkedList.lastIndexOf("b"));
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_a_c_a_d_e_onLastIndexOf_a_returns_4() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("d"));
        assertEquals(4, customDoublyLinkedList.lastIndexOf("a"));
    }

    @Test
    public void givenEmptyLinkedList_on_removeFirst_throws_NoSuchElementException() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertThrows(NoSuchElementException.class, customDoublyLinkedList::removeFirst);
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_on_removeFirst_returns_a_andHeadSetsTo_b() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertEquals("a", customDoublyLinkedList.removeFirst());
        assertEquals("b", customDoublyLinkedList.peek());
        assertEquals(2, customDoublyLinkedList.size());
    }

    @Test
    public void givenEmptyLinkedListOfType_String_on_removeLast_throws_NoSuchElementException() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertThrows(NoSuchElementException.class, customDoublyLinkedList::removeLast);
    }

    @Test
    public void givenLinkedListOfType_String_withValues_a_b_c_on_removeLast_returns_c_andSetsLastElementTo_b() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertEquals("c", customDoublyLinkedList.removeLast());
        assertEquals("b", customDoublyLinkedList.peekLast());
        assertEquals(2, customDoublyLinkedList.size());
    }

    @Test
    public void givenEmptyLinkedListOfType_String_on_removeFirstOccurrence_returns_false() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertFalse(customDoublyLinkedList.removeFirstOccurrence(null));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_withValues_a_b_c_on_removeFirstOccurrenceOf_d_returns_false() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertFalse(customDoublyLinkedList.removeFirstOccurrence("d"));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_withValues_a_b_c_on_removeFirstOccurrenceOf_b_returns_true() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertTrue(customDoublyLinkedList.removeFirstOccurrence("b"));
        assertEquals("a", customDoublyLinkedList.get(0));
        assertEquals("c", customDoublyLinkedList.get(1));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_on_removeLastOccurrence_returns_false() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertFalse(customDoublyLinkedList.removeLastOccurrence(null));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_withValues_a_b_c_on_removeLastOccurrenceOf_d_returns_false() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertFalse(customDoublyLinkedList.removeLastOccurrence("d"));
    }

    @Test
    public void givenEmptyLinkedListOfType_String_withValues_a_b_c_a_c_on_removeLastOccurrenceOf_a_returns_true() {
        CustomDoublyLinkedList<String> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("b"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertTrue(customDoublyLinkedList.add("a"));
        assertTrue(customDoublyLinkedList.add("c"));
        assertEquals("a", customDoublyLinkedList.get(3));
        assertTrue(customDoublyLinkedList.removeLastOccurrence("a"));
        assertEquals("c", customDoublyLinkedList.get(3));
    }

    @Test
    public void givenEmptyLinkedListOfType_Integer_withValues_1_2_3_onAddAllAtIndex_1_collection_4_5_6_returns_1_4_5_6_2_3() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        Collection<Integer> collection = new ArrayList<>();
        collection.add(4);
        collection.add(5);
        collection.add(6);
        assertTrue(customDoublyLinkedList.addAll(1, collection));
        assertEquals(1, customDoublyLinkedList.get(0));
        assertEquals(4, customDoublyLinkedList.get(1));
        assertEquals(5, customDoublyLinkedList.get(2));
        assertEquals(6, customDoublyLinkedList.get(3));
        assertEquals(2, customDoublyLinkedList.get(4));
        assertEquals(3, customDoublyLinkedList.get(5));
    }

    @Test
    public void givenLinkedListOfType_Integer_withValues_1_2_3_returnsCorrectString_on_toString() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertTrue(customDoublyLinkedList.add(1));
        assertTrue(customDoublyLinkedList.add(2));
        assertTrue(customDoublyLinkedList.add(3));
        assertEquals("{ 1, 2, 3 }", customDoublyLinkedList.toString());
    }

    @Test
    public void givenLinkedListOfType_Integer_withNpValues_returnsStringOf_emptyBraces_on_toString() {
        CustomDoublyLinkedList<Integer> customDoublyLinkedList = new CustomDoublyLinkedList<>();
        assertEquals("{ }", customDoublyLinkedList.toString());
    }
}