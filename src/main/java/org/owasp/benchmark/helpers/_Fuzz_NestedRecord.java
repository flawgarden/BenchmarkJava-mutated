package org.owasp.benchmark.helpers;

public record _Fuzz_NestedRecord<T>(_Fuzz_SimpleRecord<T> a, _Fuzz_SimpleRecord<T> b) {}
