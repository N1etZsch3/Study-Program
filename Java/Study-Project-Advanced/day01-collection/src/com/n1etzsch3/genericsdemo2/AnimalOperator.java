package com.n1etzsch3.genericsdemo2;

public interface AnimalOperator <T> {
    // 添加动物
    void add(T animal);
    // 删除动物
    void remove(T animal);
    // 修改动物
    void modify(int index, T animal);
    // 查询动物
    void query(T animal);
    // 打印动物列表
    void printList();

}
