package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RangeTest {
    @Test
    public void Test_lower_decimal() {
        Range range = new Range(0.5, 1.5);
        Assertions.assertEquals(0.5, range.getLowerBound());
    }
    @Test
    public void Test_lower_positive() {
        Range range = new Range(4, 9);
        Assertions.assertEquals(4, range.getLowerBound());
    }
    @Test
    public void Test_lower_negative() {
        Range range = new Range(-7, 9);
        Assertions.assertEquals(-7, range.getLowerBound());
    }
    @Test
    public void Test_upper_decimal() {
        Range range = new Range(0.5, 1.5);
        Assertions.assertEquals(1.5, range.getUpperBound());
    }


    @Test
    public void Test_upper_positive() {
        Range range = new Range(4, 9);
        Assertions.assertEquals(9, range.getUpperBound());
    }
    @Test
    public void Test_upper_negative() {
        Range range = new Range(-7, -5);
        Assertions.assertEquals(-5, range.getUpperBound());
    }
    @Test
    //this function not handling decimal getLength correctly
    public void Test_Length_decimal() {
        Range range = new Range(0.7, 2.35);
        Assertions.assertEquals(1.65, range.getLength());
    }
    @Test
    public void Test_Length_positive() {
        Range range = new Range(1, 6);
        Assertions.assertEquals(5, range.getLength());
    }
    @Test
    public void Test_Length_negative() {
        Range range = new Range(-5, -1);
        Assertions.assertEquals(4, range.getLength());
    }
    @Test
    public void Test_CentralValue_Even() {
        Range range = new Range(1, 6);
        Assertions.assertEquals(3.5, range.getCentralValue());
    }
    @Test
    public void Test_CentralValue_Odd() {
        Range range = new Range(1, 5);
        Assertions.assertEquals(3, range.getCentralValue());
    }

    @Test
    public void Test5() {
        Range range = new Range(1, 5);
        Assertions.assertEquals(3, range.getCentralValue());
    }
   @Test
   //function contain not handeling lower bound
    public void Test_contain_lower() {
        Range range = new Range(1, 6);
        Assertions.assertTrue(range.contains(1));
    }
  @Test
  public void Test_contain_Upper() {
      Range range = new Range(1, 6);
      Assertions.assertTrue(range.contains(6));}
    @Test
    public void Test_contain1() {
        Range range = new Range(1, 6);
        Assertions.assertTrue(range.contains(4));}
    @Test
    public void Test_contain2() {
        Range range = new Range(1, 6);
        Assertions.assertFalse(range.contains(9));}
    @Test
    public void Test_intersect1() {
        Range range = new Range(1, 6);
        Assertions.assertTrue(range.intersects(2,7));
    }
    @Test
    // doest handel second condition which check if lower bound of range <=upperbound
    public void Test_intersect2() {
        Range range = new Range(6, 10);
        Assertions.assertFalse(range.intersects(1,4));
    }
   @Test
   public void Test_constrain_valueout() {
       Range range = new Range(1, 6);
       Assertions.assertEquals(1, range.constrain(0.8));
   }
    @Test
    public void Test_constrain_valuein() {
        Range range = new Range(1, 6);
        Assertions.assertEquals(2, range.constrain(2));
    }

   @Test
    public void Test_combine() {
        Range range1 = new Range(1, 4);
        Range range2=new Range(6,10);
        Range result=new Range(1,10);
        Assertions.assertEquals(result, Range.combine(range2,range1));
    }
    @Test
    public void Test_combine_null() {
        Range range1 = null;
        Range range2=new Range(6,10);
        Range result=new Range(6,10);
        Assertions.assertEquals(result, Range.combine(range2,range1));
    }

    @Test
    public void Test20() {
        Range range1=null;
        Range range2= null;
        Range result=null;
        Assertions.assertEquals(result, Range.combine(range2,range1));
    }

    @Test
    public void Test_Expandto_in() {
        Range range=new Range(6,10);
        Range result=new Range(6,10);
        Assertions.assertEquals(result, Range.expandToInclude(range,7));
    }
    @Test
    public void Test_Expandto_out() {
        Range range=new Range(6,10);
        Range result=new Range(3,10);
        Assertions.assertEquals(result, Range.expandToInclude(range,3));
    }
    @Test
    public void Test_Expand() {
        Range range=new Range(2,6);
        Range result=new Range(1,8);
        Assertions.assertEquals(result, Range.expand(range,0.25,0.5));
    }
    @Test
    public void test_expand_null(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> Range.expand(null,0.25,0.5));}
    @Test
        public void Test1_shift1() {
        Range range=new Range(6,10);
        Range result= new Range(8,12);
        Assertions.assertEquals(result, Range.shift(range,2));
    }
    @Test
    public void Test_shift2() {
        Range range=new Range(-4,6);
        Range result= new Range(-2,8);
        Assertions.assertEquals(result, Range.shift(range,2));
    }
    @Test
    public void test_shift1_null(){
        Range range1=null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Range.shift(range1,2));}
    @Test
    public void Test_shift_three() {
        Range range=new Range(-4,6);
        Range result= new Range(0,12);
        Assertions.assertEquals(result, Range.shift(range,6,false));
    }
    @Test
    public void test_shift_null(){
        Range range1=null;
        Assertions.assertThrows(IllegalArgumentException.class, () -> Range.shift(range1,2,false));}


}






