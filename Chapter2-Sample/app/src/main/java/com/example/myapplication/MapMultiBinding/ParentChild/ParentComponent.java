package com.example.myapplication.MapMultiBinding.ParentChild;

import java.util.Set;

import dagger.Component;

@Component(modules = ParentModule.class)
public interface ParentComponent {
    Set<String> strings();
    ChildComponent.Builder childCompBuilder();
}
