/**
 * You are strictly prohibited to copy, disclose, distribute, modify, or use this program in part
 * or as a whole without the prior written consent of Phoenix Co., Ltd.
 * Phoenix Co., Ltd., owns the intellectual property rights in and to this program.
 * <p>
 * (Copyright ⓒ 2019 Phoenix Co., Ltd. All Rights Reserved Confidential)
 */
package com.example.demonnn.model;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueItemReader<T> implements ItemReader<T> {

    private Queue<T> queue;

    public QueueItemReader(List<T> data) {
        this.queue = new LinkedList<>(data);
    }

    @Override
    public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        return this.queue.poll();
    }
}