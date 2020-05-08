package Interview.highFre;

//给定一个bufferapi每次能读取4个字符，现要求设计一个新的api,n能读取任意个数的字符
//buffer4()

/*
思路：
1.初始化一个字符队列，size为4；
2.接入字符流，并调用bufferapi进行读取；
3.如果队列为空，则将当前读取的元素插入队列；
4.如果队列不为空，则从当前队列取出元素并输出，并对输出个数进行计数；
5.若输出个数小于要求的个数，则继续输出；
 */

import java.util.LinkedList;
import java.util.Queue;

public class BufferApi {

    public static char[] bufferAny (char[] source, int n) {

        char[] res = new char[n];

        Queue<Character> q = new LinkedList<>();

        return res;
    }

}
