/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package javaswingdev.impl;

/**
 *
 * @author m0ng3
 * @param <T>
 */
public interface DisplayValueProvider<T> {
    String getDisplayValue(T item);
}
