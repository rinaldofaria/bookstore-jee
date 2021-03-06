package br.ufrn.imd.books.beans.book;

import java.util.List;

import br.ufrn.imd.books.entity.BookEntity;
import br.ufrn.imd.books.entity.RegistryEntity;
import br.ufrn.imd.books.exceptions.BookstoreUnknownException;

/**
 * BookCommonEJB
 */
public interface BookCommonEJB {
  BookEntity createNew(final BookEntity book) throws BookstoreUnknownException;
  List<BookEntity> getAll() throws BookstoreUnknownException;
  BookEntity addRegistry(final Long bookId, final RegistryEntity registry) throws BookstoreUnknownException;
}