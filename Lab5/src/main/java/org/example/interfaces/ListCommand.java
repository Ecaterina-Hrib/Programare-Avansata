package org.example.interfaces;

import org.example.classes.Item;

import java.io.IOException;

public interface ListCommand {
  static void view(Item doc) throws IOException{}
}
